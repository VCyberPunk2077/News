package com.vcyberpunk.news.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vcyberpunk.news.presentation.screen.settings.SettingsScreen
import com.vcyberpunk.news.presentation.screen.subscriptions.SubscriptionsScreen

private const val SUBSCRIPTIONS_SCREEN_ROUTE = "subscriptions"
private const val SETTINGS_SCREEN_ROUTE = "settings"

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Subscriptions.route
    ) {
        composable(route = Screen.Subscriptions.route) {
            SubscriptionsScreen(
                onNavigateToSettings = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {

    data object Subscriptions: Screen(SUBSCRIPTIONS_SCREEN_ROUTE)

    data object Settings: Screen(SETTINGS_SCREEN_ROUTE)


}