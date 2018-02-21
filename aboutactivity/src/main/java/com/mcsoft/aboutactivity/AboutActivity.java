package com.mcsoft.aboutactivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

public class AboutActivity extends AppCompatActivity
{

   private TextView lblVersion, lblRecommendedApps, lblRateThisApp, lblFollowUsOn, lblContactUsOnEmail, lblApplicationName, lblDeveloper, lblThanks, lblOpenSource;
   private FloatingActionButton fabShare, fabContact;
   private AppCompatRatingBar ratingBar;
   private CardView cardRecommendedApps, cardAppVersion, cardLicense, cardRateApp, cardFollowOnSocial, cardGeneral, cardContactUsOnEmail;
   public static ImageView imgLogoApp, imgCompanyLogo, imgFollowFacebook, imgFollowGoogle, imgFollowTelegram;
   private AboutActivityBuilder.Builder builder;
   private NightModeHelper mNightModeHelper;
   private List<Notice> list;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      //Getting Builder
      Intent intent = getIntent();
      if (intent == null)
      {
         return;
      }
      builder = (AboutActivityBuilder.Builder) intent.getSerializableExtra("builder");
      if (builder.idTheme != 0)
      {
         setTheme(builder.idTheme);
      }
      setContentView(R.layout.layout_about_activity);
      setupActionBar();

      lblVersion = (TextView) findViewById(R.id.lblVersion);
      lblRecommendedApps = (TextView) findViewById(R.id.lblRecommendedApps);
      lblRateThisApp = (TextView) findViewById(R.id.lblRateThisApp);
      lblFollowUsOn = (TextView) findViewById(R.id.lblFollowUsOn);
      lblContactUsOnEmail = (TextView) findViewById(R.id.lblContactUsOnEmail);
      lblApplicationName = (TextView) findViewById(R.id.lblApplicationName);
      lblDeveloper = (TextView) findViewById(R.id.lblDeveloper);
      lblThanks = (TextView) findViewById(R.id.lblThanks);
      lblOpenSource = (TextView) findViewById(R.id.lblOpenSource);
      fabContact = (FloatingActionButton) findViewById(R.id.fabContact);
      fabShare = (FloatingActionButton) findViewById(R.id.fabShare);
      ratingBar = (AppCompatRatingBar) findViewById(R.id.ratingBar);
      cardRecommendedApps = (CardView) findViewById(R.id.cardRecommendedApps);
      cardAppVersion = (CardView) findViewById(R.id.cardAppVersion);
      cardLicense = (CardView) findViewById(R.id.cardLicense);
      cardRateApp = (CardView) findViewById(R.id.cardRateApp);
      cardFollowOnSocial = (CardView) findViewById(R.id.cardFollowOnSocial);
      cardContactUsOnEmail = (CardView) findViewById(R.id.cardContactUsOnEmail);
      cardGeneral = (CardView) findViewById(R.id.cardGeneral);
      imgLogoApp = (ImageView) findViewById(R.id.imgLogoApp);
      imgCompanyLogo = (ImageView) findViewById(R.id.imgCompanyLogo);
      imgFollowFacebook = (ImageView) findViewById(R.id.imgFollowFacebook);
      imgFollowGoogle = (ImageView) findViewById(R.id.imgFollowGoogle);
      imgFollowTelegram = (ImageView) findViewById(R.id.imgFollowTelegram);

      // make invisible all cards
      initCard();

      if(builder.showAppVersion == true)
      {
         makeVisible(cardAppVersion);
         if(builder.textLabel == null && builder.version == null)
         {
            makeInvisible(cardAppVersion);
         }
         else
         {
            lblVersion.setText(builder.textLabel + builder.version);
         }
      }
      if(builder.showLicense == true)
      {
         makeVisible(cardLicense);
         if(builder.textTitleDialogLicense == null && builder.textCloseButton == null)
         {
            makeInvisible(cardLicense);
         }
         else
         {
            lblOpenSource.setText(builder.textOpenSourceLicense);
            cardLicense.setOnClickListener(new View.OnClickListener()
            {
               @Override
               public void onClick(View v)
               {
                  showOpenLicenseDialog(v, builder.notices, builder.textTitleDialogLicense, builder.textCloseButton);
               }
            });
         }
      }
      if(builder.showFollowOnSocial == true)
      {
         makeVisible(cardFollowOnSocial);
         if(builder.facebookPath == null && builder.googlePlusPath == null && builder.telegramPath == null)
         {
            makeInvisible(cardFollowOnSocial);
         }
         else
         {
            lblFollowUsOn.setText(builder.textFollowUsOn);
         }
         if(builder.facebookPath != null)
         {
            imgFollowFacebook.setOnClickListener(new View.OnClickListener()
            {
               @Override
               public void onClick(View v)
               {
                  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(builder.facebookPath)));
               }
            });
            makeVisible(imgFollowFacebook);
         }
         else
         {
            makeInvisible(imgFollowFacebook);
         }
         if(builder.googlePlusPath != null)
         {
            imgFollowGoogle.setOnClickListener(new View.OnClickListener()
            {
               @Override
               public void onClick(View v)
               {
                  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(builder.googlePlusPath)));
               }
            });
            makeVisible(imgFollowGoogle);
         }
         else
         {
            makeInvisible(imgFollowGoogle);
         }
         if(builder.telegramPath != null)
         {
            imgFollowTelegram.setOnClickListener(new View.OnClickListener()
            {
               @Override
               public void onClick(View v)
               {
                  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(builder.telegramPath)));
               }
            });
            makeVisible(imgFollowTelegram);
         }
         else
         {
            makeInvisible(imgFollowTelegram);
         }
      }

      if(builder.showGeneral == true)
      {
         makeVisible(cardGeneral);
         if(builder.textThanks == null && builder.textDeveloper == null && builder.packageName == null && builder.textApplicationName == null && builder.textTitleChooserShare == null)
         {
            makeInvisible(cardGeneral);
         }
         else
         {
            imgCompanyLogo.setImageDrawable(ContextCompat.getDrawable(AboutActivity.this, builder.companyLogo));
            imgLogoApp.setImageDrawable(ContextCompat.getDrawable(AboutActivity.this, builder.appLogo));
            lblApplicationName.setText(builder.textApplicationName);
            lblThanks.setText(builder.textThanks);
            lblDeveloper.setText(builder.textDeveloper);
            fabShare.setOnClickListener(new View.OnClickListener()
            {
               @Override
               public void onClick(View view)
               {
                  Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                  sharingIntent.setType("text/plain");
                  String shareBody = "http://play.google.com/store/apps/details?id=" + builder.packageName;
                  sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                  sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                  startActivity(Intent.createChooser(sharingIntent, builder.textTitleChooserShare));
               }
            });
         }
      }

      if(builder.showRecommendedApps == true)
      {
         makeVisible(cardRecommendedApps);
         if(builder.marketDevPageLink == null && builder.textLabelRecommendedApps == null)
         {
            makeInvisible(cardRecommendedApps);
         }
         else
         {
            lblRecommendedApps.setText(builder.textLabelRecommendedApps);
            cardRecommendedApps.setOnClickListener(new View.OnClickListener()
            {
               @Override
               public void onClick(View v)
               {
                  Uri uri = Uri.parse(builder.marketDevPageLink);
                  Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                  try
                  {
                     startActivity(goToMarket);
                  } catch (ActivityNotFoundException e)
                  {
                     startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=8629062604716991650&hl")));
                  }
               }
            });
         }
      }

      if(builder.showRateApp == true)
      {
         makeVisible(cardRateApp);
         if(builder.packageName == null && builder.textLabelRateThisApp == null)
         {
            makeInvisible(cardRateApp);
         }
         else
         {
            lblRateThisApp.setText(builder.textLabelRateThisApp);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
            {
               @Override
               public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
               {
                  Uri uri = Uri.parse("market://details?id=" + builder.packageName);
                  Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                  try
                  {
                     startActivity(goToMarket);
                  } catch (ActivityNotFoundException e)
                  {
                     startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + builder.packageName)));
                  }
               }
            });
         }
      }

      if(builder.showContactUsOnEmail== true)
      {
         makeVisible(cardContactUsOnEmail);
         if (builder.emailAddress == null && builder.textContactUsOnEmail == null && builder.textSendAMail == null)
         {
            makeInvisible(cardContactUsOnEmail);
         }
         else
         {
            lblContactUsOnEmail.setText(builder.textContactUsOnEmail);
            fabContact.setOnClickListener(new View.OnClickListener()
            {
               @Override
               public void onClick(View view)
               {
                  Intent i = new Intent(Intent.ACTION_SEND);
                  i.setType("message/rfc822");
                  i.putExtra(Intent.EXTRA_EMAIL, new String[]{builder.emailAddress});
                  try
                  {
                     startActivity(Intent.createChooser(i, builder.textSendAMail));
                  } catch (ActivityNotFoundException ex)
                  {
                     Toast.makeText(AboutActivity.this, "No email client", Toast.LENGTH_SHORT).show();
                  }
               }
            });
         }
      }
   }

   private void makeInvisible(CardView card)
   {
      card.setVisibility(View.INVISIBLE);
   }

   private void makeVisible(CardView card)
   {
      card.setVisibility(View.VISIBLE);
   }

   private void makeVisible(ImageView imageView)
   {
      imageView.setVisibility(View.VISIBLE);
   }

   private void makeInvisible(ImageView imageView)
   {
      imageView.setVisibility(View.GONE);
   }

   private void initCard()
   {
      int visibility = View.GONE;
      cardAppVersion.setVisibility(visibility);
      cardRateApp.setVisibility(visibility);
      cardLicense.setVisibility(visibility);
      cardFollowOnSocial.setVisibility(visibility);
      cardGeneral.setVisibility(visibility);
      cardRecommendedApps.setVisibility(visibility);
      cardContactUsOnEmail.setVisibility(visibility);
   }

   private void setupActionBar()
   {
      Window window = getWindow();
      // finally change the color
      if(Build.VERSION.SDK_INT >= 21)
      {
         // clear FLAG_TRANSLUCENT_STATUS flag:
         window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
         // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
         window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      }
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null)
      {
         // Show the Up button in the action bar.
         actionBar.setDisplayHomeAsUpEnabled(true);
      }
   }

   public void showOpenLicenseDialog(final View view, Notices notices, String titleDialogLicense, String closeText)
   {
      new LicensesDialog.Builder(this)
              .setNotices(notices)
              .setTitle(titleDialogLicense)
              .setCloseText(closeText)
              .setIncludeOwnLicense(true)
              .build()
              .show();
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      switch (item.getItemId())
      {
         case android.R.id.home:
            finish();
            return true;
         default:
            return super.onOptionsItemSelected(item);
      }
   }
}
