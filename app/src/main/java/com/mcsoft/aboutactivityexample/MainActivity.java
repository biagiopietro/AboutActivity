package com.mcsoft.aboutactivityexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mcsoft.aboutactivity.AboutActivity;
import com.mcsoft.aboutactivity.AboutActivityBuilder;
import com.mcsoft.aboutactivity.NoticesParcelable;

import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

public class MainActivity extends AppCompatActivity
{
    private String facebookPath="https://m.facebook.com/marinocapece/";
    private String googlePlusPath="https://plus.google.com/116633121688774552207";
    private String telegramPath="https://t.me/mc_soft";
    private String marketDevPageLink="https://play.google.com/store/apps/dev?id=8629062604716991650";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NoticesParcelable notices = new NoticesParcelable();
        notices.addNotice(new Notice("Tap Bar Menu", "https://github.com/michaldrabik/TapBarMenu", "Copyright (C) 2015 Michal Drabik", new ApacheSoftwareLicense20()));
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new AboutActivityBuilder.Builder(MainActivity.this)
                        .showAppVersion(true, "Version: ", "1.0") // Optional
                        .showFollowOnSocial(true,"Follow us on", facebookPath, googlePlusPath, telegramPath) // Optional
                        .showLicense(true, notices, "Open Source Library","Open Source License", "Close") // Optional - default: false
                        .showRecommendedApps(true, marketDevPageLink, "Recommended by") // Optional - default: false
                        .setAppLogo(R.drawable.logo_mc_soft)
                        .setCompanyLogo(R.drawable.logo_mc_soft)
                        .showRateApp(true, getPackageName(), "Rate our app") // Optional - default: false
                        .showGeneral(true, getString(R.string.app_name), getPackageName(), "Developed by MC SOFT", "Thank you so much for downloading our application", "Share with") // Optional - default: false
                        .showContactUsOnEmail(true, "marinocapecemc@gmail.com", "For any information contact us", "Send a mail..")
                        .showAboutActivity();
            }
        });
    }
}
