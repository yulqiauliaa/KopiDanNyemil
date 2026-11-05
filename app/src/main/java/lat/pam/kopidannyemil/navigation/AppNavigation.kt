package lat.pam.kopidannyemil.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import lat.pam.kopidannyemil.data.AppViewModel
import lat.pam.kopidannyemil.data.UserAccount
import lat.pam.kopidannyemil.ui.screens.*

object Routes {
    const val SPLASH = "splash"
    const val SIGNUP = "signup"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"
    const val PROFILE = "profile"
    const val ADDRESS = "address"
    const val CONFIRM = "confirm"
}

@Composable
fun AppNavigation() {
    val nav = rememberNavController()
    val vm: AppViewModel = viewModel()

    Surface(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        NavHost(navController = nav, startDestination = Routes.SPLASH) {
            composable(Routes.SPLASH) {
                SplashScreen(onStart = { nav.navigate(Routes.SIGNUP) })
            }
            composable(Routes.SIGNUP) {
                SignUpScreen(
                    onRegister = { nav.navigate(Routes.REGISTER) },
                    onLogin = { nav.navigate(Routes.LOGIN) }
                )
            }
            composable(Routes.LOGIN) {
                LoginScreen(onLogin = { username, password ->
                    val ok = vm.login(username, password)
                    if (ok) {
                        nav.navigate(Routes.HOME) { popUpTo(Routes.SPLASH) { inclusive = true } }
                    }
                    ok
                })
            }
            composable(Routes.REGISTER) {
                RegisterScreen(onRegister = { name, username, email, phone, password ->
                    val error = vm.register(UserAccount(name, username, email, phone, password))
                    if (error == null) {
                        nav.navigate(Routes.HOME) { popUpTo(Routes.SPLASH) { inclusive = true } }
                    }
                    error
                })
            }
            composable(Routes.HOME) {
                HomeScreen(
                    userName = vm.userName,
                    onOrder = { nav.navigate(Routes.ADDRESS) },
                    onProfile = { nav.navigate(Routes.PROFILE) }
                )
            }
            composable(Routes.PROFILE) {
                vm.currentUser?.let { user ->
                    ProfileScreen(
                        user = user,
                        onSave = { name, email, phone, address ->
                            vm.updateProfile(name, email, phone, address)
                        },
                        onLogout = {
                            vm.logout()
                            nav.navigate(Routes.SPLASH) { popUpTo(nav.graph.id) { inclusive = true } }
                        },
                        onHome = { nav.popBackStack() }
                    )
                }
            }
            composable(Routes.ADDRESS) {
                AddressScreen(
                    defaultName = vm.currentUser?.fullName ?: "",
                    defaultAddress = vm.currentUser?.address ?: "",
                    onSubmit = { address ->
                        vm.fullAddress = address
                        nav.navigate(Routes.CONFIRM)
                    }
                )
            }
            composable(Routes.CONFIRM) {
                ConfirmationScreen(
                    userName = vm.userName,
                    onOk = { nav.navigate(Routes.HOME) { popUpTo(Routes.HOME) { inclusive = true } } }
                )
            }
        }
    }
}