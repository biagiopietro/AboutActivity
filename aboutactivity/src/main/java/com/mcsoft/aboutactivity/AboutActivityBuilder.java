package com.mcsoft.aboutactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

/**
 * Created by biagio on 11/02/18.
 */

public class AboutActivityBuilder
{
    public static class Builder implements Serializable
    {
        protected transient Activity acc;
        protected transient Fragment frag;
        /* Recommended apps section*/
        protected boolean showRecommendedApps = false;
        protected String marketDevPageLink;
        protected String textLabelRecommendedApps;
        /* License section */
        protected boolean showLicense = false;
        public static NoticesParcelable notices;
        protected String textTitleDialogLicense;
        protected String textCloseButton;
        protected String textOpenSourceLicense;
        /* App version section */
        protected boolean showAppVersion = false;
        protected String textLabel = null;
        protected String version = null;
        /* Rate app section*/
        protected boolean showRateApp = false;
        protected String packageName;
        protected String textLabelRateThisApp;
        /* Follow on social section*/
        protected boolean showFollowOnSocial = false;
        protected String textFollowUsOn;
        protected String facebookPath;
        protected String googlePlusPath;
        protected String telegramPath;
        /* General section*/
        protected boolean showGeneral = false;
        protected String textApplicationName;
        protected String textDeveloper;
        protected String textThanks;
        protected String textTitleChooserShare;
        protected int companyLogo;
        protected int appLogo;
        /* Contact us on email*/
        protected boolean showContactUsOnEmail = false;
        protected String emailAddress;
        protected String textContactUsOnEmail;
        protected String textSendAMail;

        /**/


        private Intent intent;

        public Builder(@NonNull Activity act)
        {
            this.acc = act;
        }

        public Builder(@NonNull Fragment frag)
        {
            this.frag = frag;
        }


        /**
         * Set the ImageView in recommented card
         * @param companyLogo
         * @return this builder
         */
        public Builder setCompanyLogo(int companyLogo)
        {
            this.companyLogo = companyLogo;
            return this;
        }

        /**
         * Set ImageView in general card
         * @param appLogo
         * @return this builder
         */
        public Builder setAppLogo(int appLogo)
        {
            this.appLogo = appLogo;
            return this;
        }

        /**
         *
         * @param showLicense true = show card, otherwise the card will be invisible
         * @param notices list of notices where each element is Notice object (es. new Notice("<lib_name>", "<github_link>", "<copyright>", new ApacheSoftwareLicense20())))
         * @param textTitleDialogLicense text like "Open Source License"
         * @param textCloseButton text like "Close"
         * @return this builder
         */
        public Builder showLicense(boolean showLicense, NoticesParcelable notices, String textOpenSourceLicense, String textTitleDialogLicense, String textCloseButton)
        {
            this.showLicense = showLicense;
            this.notices = notices;
            this.textOpenSourceLicense = textOpenSourceLicense;
            this.textTitleDialogLicense = textTitleDialogLicense;
            this.textCloseButton = textCloseButton;
            return this;
        }

        /**
         * Show a card with fab
         * @param showContactUsOnEmail true = show card, otherwise the card will be invisible
         * @param emailAddress email address like "example@gmail.com"
         * @param textContactUsOnEmail text like "For any information contact us"
         * @param textSendAMail text that you see when the choose (to pic the email application) (es. "Send a mail..")
         * @return this builder
         */
        public Builder showContactUsOnEmail(boolean showContactUsOnEmail, String emailAddress, String textContactUsOnEmail, String textSendAMail)
        {
            this.showContactUsOnEmail = showContactUsOnEmail;
            this.emailAddress = emailAddress;
            this.textContactUsOnEmail = textContactUsOnEmail;
            this.textSendAMail = textSendAMail;
            return this;
        }
        /**
         *
         * @param showRecommendedApps true = show card, otherwise the card will be invisible
         * @param marketDevPageLink link to the developer's page
         * @param textLabelRecommendedApps text like "Recommended by Someone"
         * @return this builder
         */
        public Builder showRecommendedApps(boolean showRecommendedApps, String marketDevPageLink, String textLabelRecommendedApps)
        {
            this.showRecommendedApps = showRecommendedApps;
            this.marketDevPageLink = marketDevPageLink;
            this.textLabelRecommendedApps = textLabelRecommendedApps;
            return this;
        }

        /**
         * Show a card with version of the app
         * @param showAppVersion true = show card, otherwise the card will be invisible
         * @param textLabel text to show (eg. "Version:")
         * @param version version of the app (eg. "1.0")
         * @return this builder
         */
        public Builder showAppVersion(boolean showAppVersion, String textLabel, String version)
        {
            this.showAppVersion = showAppVersion;
            this.textLabel = textLabel;
            this.version = version;
            return this;
        }

        /**
         * Show a card with 3 button (Facebook, Google and Telegram)
         * @param showFollowOnSocial true = show card, otherwise the card will be invisible
         * @param textFollowUsOn text like "Follow us on"
         * @param facebookPath facebook link (if it is null than the Facebook button will not be showed)
         * @param googlePlusPath google+ link (if it is null than the GooglePlus button will not be showed)
         * @param telegramPath telegram link (if it is null than the Telegram button will not be showed)
         * @return this builder
         */
        public Builder showFollowOnSocial(boolean showFollowOnSocial, String textFollowUsOn, String facebookPath, String googlePlusPath, String telegramPath)
        {
            this.showFollowOnSocial = showFollowOnSocial;
            this.textFollowUsOn = textFollowUsOn;
            this.facebookPath = facebookPath;
            this.googlePlusPath = googlePlusPath;
            this.telegramPath = telegramPath;
            return this;
        }

        /**
         * Show a card with starts to rate the app (on click will opened the app in the playstore)
         * @param showRateApp true = show card, otherwise the card will be invisible
         * @param packageName package name needed to open the app in the playstore (eg. just call the function "getPackageName()")
         * @param textLabelRateThisApp text like "Rate this app"
         * @return this builder
         */
        public Builder showRateApp(boolean showRateApp, String packageName, String textLabelRateThisApp)
        {
            this.showRateApp = showRateApp;
            this.packageName = packageName;
            this.textLabelRateThisApp = textLabelRateThisApp;
            return this;
        }

        /**
         * Show a card with the application logo and so on
         * @param showGeneral true = show card, otherwise the card will be invisible
         * @param textApplicationName the application name
         * @param packageName package name needed to open the app in the playstore (eg. just call the function "getPackageName()")
         * @param textDeveloper text like "Developed by Developer"
         * @param textThanks text like "Thank you so much for downloading our application"
         * @param textTitleChooserShare text like "Share with"
         * @return this builder
         */
        public Builder showGeneral(boolean showGeneral, String textApplicationName, String packageName, String textDeveloper, String textThanks, String textTitleChooserShare)
        {
            this.showGeneral = showGeneral;
            this.textApplicationName = textApplicationName;
            this.packageName = packageName;
            this.textDeveloper = textDeveloper;
            this.textThanks = textThanks;
            this.textTitleChooserShare = textTitleChooserShare;
            return this;
        }

        public void showAboutActivity()
        {
            if (acc == null)
            {
                return;
            }
            Intent intent = new Intent(acc, AboutActivity.class);
            intent.putExtra("builder", (Serializable) this);


            if (frag != null)
            {
                frag.startActivity(intent);
            } else
            {
                acc.startActivity(intent);
            }
        }
    }
}
