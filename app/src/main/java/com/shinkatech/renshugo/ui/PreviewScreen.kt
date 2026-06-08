//package com.shinkatech.renshugo.ui
//
//import android.content.res.Configuration
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
//import com.shinkatech.renshugo.presentation.screen.SignUpScreen.SignUpScreen
//import com.shinkatech.renshugo.presentation.screen.loginScreen.LoginScreen
//import com.shinkatech.renshugo.ui.theme.RenshugoTheme
//
//
//// ─────────────────────────────────────────────
//// STEP 1: Combined Annotation
//// ─────────────────────────────────────────────
//// Stacks all device sizes × both themes = 12 previews in one annotation.
//// Add or remove @Preview blocks here to control what you check globally.
//
//@Preview(name = "1 · 320dp · Light",  widthDp = 320,  heightDp = 568,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "2 · 320dp · Dark",   widthDp = 320,  heightDp = 568,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "3 · 360dp · Light",  widthDp = 360,  heightDp = 640,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "4 · 360dp · Dark",   widthDp = 360,  heightDp = 640,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "5 · 411dp · Light",  widthDp = 411,  heightDp = 891,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "6 · 411dp · Dark",   widthDp = 411,  heightDp = 891,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "7 · 480dp · Light",  widthDp = 480,  heightDp = 960,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "8 · 480dp · Dark",   widthDp = 480,  heightDp = 960,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "9 · Fold · Light",   widthDp = 673,  heightDp = 841,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "10· Fold · Dark",    widthDp = 673,  heightDp = 841,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "11· Tablet · Light", widthDp = 1280, heightDp = 800,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "12· Tablet · Dark",  widthDp = 1280, heightDp = 800,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//annotation class AllDeviceAndThemePreviews
//
//
//// ─────────────────────────────────────────────
//// STEP 2: Apply the annotation to LoginScreen
//// ─────────────────────────────────────────────
//
//@AllDeviceAndThemePreviews
//@Composable
//fun LoginScreenPreview() {
//    RenshugoTheme {
//        SignUpScreen()
//    }
//}
//
//
//// ─────────────────────────────────────────────
//// STEP 3: Isolated breakpoint previews
//// Use these when you spot a bug in the combined view
//// and want to zoom in on a single size without noise.
//// ─────────────────────────────────────────────
//
//@Preview(name = "DEBUG · 320dp Light", widthDp = 320, heightDp = 568, showBackground = true)
//@Composable
//fun LoginDebug320() {
//    RenshugoTheme {
//        SignUpScreen()
//    }
//}
//
//@Preview(name = "DEBUG · 360dp Light", widthDp = 360, heightDp = 640, showBackground = true)
//@Composable
//fun LoginDebug360() {
//    RenshugoTheme {
//        SignUpScreen()
//    }
//}
//
//@Preview(name = "DEBUG · 411dp Light", widthDp = 411, heightDp = 891, showBackground = true)
//@Composable
//fun LoginDebug411() {
//    RenshugoTheme {
//        SignUpScreen()
//    }
//}
//
//@Preview(name = "DEBUG · Fold Unfolded", widthDp = 673, heightDp = 841, showBackground = true)
//@Composable
//fun LoginDebugFold() {
//    RenshugoTheme {
//        SignUpScreen()
//    }
//}
//
//@Preview(name = "DEBUG · Tablet Landscape", widthDp = 1280, heightDp = 800, showBackground = true)
//@Composable
//fun LoginDebugTablet() {
//    RenshugoTheme {
//        SignUpScreen()
//    }
//}
//
//
//// ─────────────────────────────────────────────
//// STEP 4: Reusable standalone annotations
//// Keep these in a shared PreviewAnnotations.kt
//// and import them on any screen.
//// ─────────────────────────────────────────────
//
//// Phones only (light + dark) — fastest to render
//@Preview(name = "Phone S · Light", widthDp = 320, heightDp = 568,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "Phone S · Dark",  widthDp = 320, heightDp = 568,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "Phone M · Light", widthDp = 360, heightDp = 640,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "Phone M · Dark",  widthDp = 360, heightDp = 640,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "Phone L · Light", widthDp = 411, heightDp = 891,  uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "Phone L · Dark",  widthDp = 411, heightDp = 891,  uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//annotation class PhonePreviewsOnly
//
//// Large canvas only — use for tablet/fold-specific screens
//@Preview(name = "Fold · Light",   widthDp = 673,  heightDp = 841, uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "Fold · Dark",    widthDp = 673,  heightDp = 841, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "Tablet · Light", widthDp = 1280, heightDp = 800, uiMode = Configuration.UI_MODE_NIGHT_NO,  showBackground = true)
//@Preview(name = "Tablet · Dark",  widthDp = 1280, heightDp = 800, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//annotation class LargeScreenPreviewsOnly