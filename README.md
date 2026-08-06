### Steps to build a new .aar
 * Clone this repo
 * Open it in a current Android Studio release
 * Build requirements:
   * JDK 17+
   * Gradle 9.4.1
   * Android Gradle Plugin 9.2.1
   * Android SDK Platform 36
 * Update any source files as needed (current version is: https://github.com/zxing/zxing/releases/tag/BS-4.7.6):
   - Copy all files from `core`
   - From the `android` folder grab the src/.../android folder and paste that to the appropriate package
   - Same for `android-core`
   - Note that R.java is generated when building and is supposed to be in build/generated/source/r/debug/barcodescanner/xservices/nl/barcodescanner/R
   - Re-add the 'flip camera' feature and the 'portrait scan' feature I added before!
   - Make sure no `app_name` tag is active in the `res/values*/string.xml` files
 * (Finder/Explorer): Clean barcodescanner > build > outputs
 * Open the Gradle toolwindow
 * Run `:barcodescanner:assembleRelease`
 * The release `.aar` will be generated in `barcodescanner/build/outputs/aar`
 * Commit and push any changes made!

### Compatibility notes
 * The library now builds against Android SDK 36 and keeps `minSdkVersion 15`.
 * Android Gradle Plugin 9.2.1 officially supports Android SDK 36, so no `android.suppressUnsupportedCompileSdk=36` override is needed.
 * `CaptureActivity` now requests `CAMERA` permission at runtime on Android 6.0+ before opening the camera.
 * Wi-Fi QR codes are parsed and displayed, but the library does not offer an action to modify the device's Wi-Fi configuration or add Wi-Fi permissions to consuming apps.
 * If your app declares `com.google.zxing.client.android.CaptureActivity` in its own manifest, add the Android 12+ `android:exported` attribute there as appropriate for your app (typically `false`).

### The generated .aar is used in:
* [NativeScript BarcodeScanner Plugin](https://github.com/EddyVerbruggen/nativescript-barcodescanner/)
* [Cordova BarcodeScanner Plugin](https://github.com/Telerik-Verified-Plugins/BarcodeScanner/)
