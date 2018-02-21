# AboutActivity

[![](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
<a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#JELLY_BEAN"><img src="https://img.shields.io/badge/API-16%2B-blue.svg?style=flat" alt="API" /></a>

A simple, activity to show some information about the application.

Screenshot
:-------------------------
![](https://i.imgur.com/aZBAe3D.jpg?1) ![](https://i.imgur.com/Lst7WJZ.jpg?1) ![](https://i.imgur.com/EUEUhAf.jpg?1)

Gif
:-------------------------
![](https://i.imgur.com/o0QMYwO.gif)

## Install

Add this to your project build.gradle
``` gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Add this to your module build.gradle

```gradle
    dependencies {
            compile 'com.github.biagiopietro:AboutActivity:1.4'
    }
```
### Usage

Open the picker in your activity/fragment:

```java
// Define some links (Optional)
private String facebookPath="https://m.facebook.com/marinocapece/";
private String googlePlusPath="https://plus.google.com/116633121688774552207";
private String telegramPath="https://t.me/mc_soft";
private String marketDevPageLink="https://play.google.com/store/apps/dev?id=8629062604716991650";

// Define the opensource library used in the application
final NoticesParcelable notices = new NoticesParcelable();
notices.addNotice(new Notice("MultiAppPicker", "https://github.com/biagiopietro/MultiAppPicker", "Copyright 2018 biagiopietro", new ApacheSoftwareLicense20()));
notices.addNotice(new Notice("Mc Night Mode", "https://github.com/PuffoCyano/mcnightmode", "Copyright 2018 Alessandro Marino", new ApacheSoftwareLicense20()));

new AboutActivityBuilder.Builder(MainActivity.this)
                        .showAppVersion(true, "Version: ", "1.0") // Optional
                        .showFollowOnSocial(true,"Follow us on", facebookPath, googlePlusPath, telegramPath) // Optional
                        .showLicense(true, notices, "Open Source Library","Open Source License", "Close") // Optional - default: false
                        .showRecommendedApps(true, marketDevPageLink, "Recommended by") // Optional - default: false
                        .setAppLogo(R.drawable.logo_mc_soft)
                        .setCompanyLogo(R.drawable.logo_mc_soft)
                        .setIdTheme(0) // Optional - default: 0 (eg. R.style.mystyle)
                        .showRateApp(true, getPackageName(), "Rate our app") // Optional - default: false
                        .showGeneral(true, getString(R.string.app_name), getPackageName(), "Developed by MC SOFT", "Thank you so much for downloading our application", "Share with") // Optional - default: false
                        .showContactUsOnEmail(true, "marinocapecemc@gmail.com", "For any information contact us", "Send a mail..")
                        .showAboutActivity();
```

### Thanks
AboutActivity utilises code from these great libraries:

- [LicensesDialog](https://github.com/PSDev/LicensesDialog)

Thanks to [Alessandro Marino](https://github.com/PuffoCyano) his help.


## License

```
Copyright 2018 biagiopietro

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
