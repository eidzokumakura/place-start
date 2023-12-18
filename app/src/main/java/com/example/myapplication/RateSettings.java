package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class RateSettings extends AppCompatActivity {

    // Чекбоксы для выбора категорий
    CheckBox create_site_checkbox;
    CheckBox context_ad_checkbox;
    CheckBox smm_and_targeting_checkbox;
    CheckBox seo_promotion_checkbox;
    CheckBox technical_support_checkbox;
    CheckBox imp_and_refine_crm_checkbox;
    CheckBox logos_checkbox;
    CheckBox polygraphy_checkbox;

    // Доп блоки у категорий
    View context_ad_block;
    View smm_and_targeting_block;
    View seo_promotion_block;
    View technical_support_block;
    View logos_block;

    // Чекбоксы контекстной рекламы
    CheckBox yandex_direct_checkbox;
    CheckBox google_ads_checkbox;

    // Чекбоксы смм и таргетинга
    CheckBox vkontakte_checkbox;
    CheckBox telegram_checkbox;
    SeekBar posts_per_week_seekbar;

    // Радио сео-продвижения
    RadioGroup seo_radios;
    RadioButton year1seo;
    RadioButton year2seo;
    RadioButton laterseo;
    // Чекбоксы технического сопровождения
    CheckBox prompt_error_checkbox;
    CheckBox engine_update_checkbox;
    CheckBox data_backup_checkbox;
    CheckBox check_domens_checkbox;
    CheckBox ssl_control_checkbox;
    CheckBox check_viruses_checkbox;
    CheckBox web_server_diagnostic_checkbox;
    CheckBox hosting_monitoring_checkbox;
    CheckBox compatibility_control_checkbox;
    CheckBox image_size_optimization_checkbox;

    // Чекбоксы логотипа и фирменного стиля
    CheckBox brand_sign_checkbox;
    CheckBox brand_name_checkbox;
    CheckBox slogan_checkbox;
    CheckBox brand_character_checkbox;
    CheckBox style_elements_checkbox;
    // Кнопка перехода к тарифу
    Button to_tariff_button;
    TextView posts;

    int control_sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_settings);
        posts = findViewById(R.id.posts);
        year1seo = findViewById(R.id.year1seo);
        year2seo = findViewById(R.id.year2seo);
        laterseo = findViewById(R.id.laterseo);
        create_site_checkbox = findViewById(R.id.create_site);
        context_ad_checkbox = findViewById(R.id.context_ad);
        context_ad_block = findViewById(R.id.context_ad_block);
        yandex_direct_checkbox = findViewById(R.id.yandex_direct);
        google_ads_checkbox = findViewById(R.id.google_ads);
        vkontakte_checkbox = findViewById(R.id.vkontakte);
        telegram_checkbox = findViewById(R.id.telegram);
        posts_per_week_seekbar = findViewById(R.id.posts_per_week);
        seo_radios = findViewById(R.id.seo_radios);
        prompt_error_checkbox = findViewById(R.id.prompt_error);
        engine_update_checkbox = findViewById(R.id.engine_update);
        data_backup_checkbox = findViewById(R.id.data_backup);
        check_domens_checkbox = findViewById(R.id.check_domens);
        ssl_control_checkbox = findViewById(R.id.ssl_control);
        check_viruses_checkbox = findViewById(R.id.check_viruses);
        web_server_diagnostic_checkbox = findViewById(R.id.web_server_diagnostic);
        hosting_monitoring_checkbox = findViewById(R.id.hosting_monitoring);
        compatibility_control_checkbox = findViewById(R.id.compatibility_control);
        image_size_optimization_checkbox = findViewById(R.id.image_size_optimization);
        brand_sign_checkbox = findViewById(R.id.brand_sign);
        brand_name_checkbox = findViewById(R.id.brand_name);
        slogan_checkbox = findViewById(R.id.slogan);
        brand_character_checkbox = findViewById(R.id.brand_character);
        style_elements_checkbox = findViewById(R.id.style_elements);

        posts_per_week_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                posts.setText("Постов в неделю: " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        context_ad_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    context_ad_block.setVisibility(View.VISIBLE);
                }
                else {
                    context_ad_block.setVisibility(View.GONE);
                    yandex_direct_checkbox.setChecked(false);
                    google_ads_checkbox.setChecked(false);
                }
            }
        });
        smm_and_targeting_checkbox = findViewById(R.id.smm_and_targeting);
        smm_and_targeting_block = findViewById(R.id.smm_and_targeting_block);
        smm_and_targeting_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    smm_and_targeting_block.setVisibility(View.VISIBLE);
                }
                else {
                    smm_and_targeting_block.setVisibility(View.GONE);
                    vkontakte_checkbox.setChecked(false);
                    telegram_checkbox.setChecked(false);
                    posts_per_week_seekbar.setProgress(1);
                }
            }
        });

        seo_promotion_checkbox = findViewById(R.id.seo_promotion);
        seo_promotion_block = findViewById(R.id.seo_promotion_block);
        seo_promotion_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    seo_promotion_block.setVisibility(View.VISIBLE);
                }
                else {
                    seo_promotion_block.setVisibility(View.GONE);
                    seo_radios.clearCheck();
                }
            }
        });

        technical_support_checkbox = findViewById(R.id.technical_support);
        technical_support_block = findViewById(R.id.technical_support_block);
        technical_support_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    technical_support_block.setVisibility(View.VISIBLE);
                }
                else {
                    technical_support_block.setVisibility(View.GONE);
                    prompt_error_checkbox.setChecked(false);
                    engine_update_checkbox.setChecked(false);
                    data_backup_checkbox.setChecked(false);
                    check_domens_checkbox.setChecked(false);
                    ssl_control_checkbox.setChecked(false);
                    check_viruses_checkbox.setChecked(false);
                    web_server_diagnostic_checkbox.setChecked(false);
                    hosting_monitoring_checkbox.setChecked(false);
                    compatibility_control_checkbox.setChecked(false);
                    image_size_optimization_checkbox.setChecked(false);
                }
            }
        });

        imp_and_refine_crm_checkbox = findViewById(R.id.imp_and_refine_crm);

        logos_checkbox = findViewById(R.id.logos);
        logos_block = findViewById(R.id.logos_block);
        logos_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    logos_block.setVisibility(View.VISIBLE);
                }
                else {
                    logos_block.setVisibility(View.GONE);
                    brand_sign_checkbox.setChecked(false);
                    brand_name_checkbox.setChecked(false);
                    slogan_checkbox.setChecked(false);
                    brand_character_checkbox.setChecked(false);
                    style_elements_checkbox.setChecked(false);
                }
            }
        });

        polygraphy_checkbox = findViewById(R.id.polygraphy);
        to_tariff_button = findViewById(R.id.to_tariff);
    }
    public void getResult(View view) {
        if ((create_site_checkbox.isChecked() || context_ad_checkbox.isChecked() ||
                smm_and_targeting_checkbox.isChecked() || seo_promotion_checkbox.isChecked() ||
                technical_support_checkbox.isChecked() || imp_and_refine_crm_checkbox.isChecked() ||
                logos_checkbox.isChecked() || polygraphy_checkbox.isChecked())
                && (!context_ad_checkbox.isChecked() || (yandex_direct_checkbox.isChecked() || google_ads_checkbox.isChecked()))
                && (!smm_and_targeting_checkbox.isChecked() || (vkontakte_checkbox.isChecked() || telegram_checkbox.isChecked()))
                && (!seo_promotion_checkbox.isChecked() || seo_radios.getCheckedRadioButtonId() != -1)
                && (!technical_support_checkbox.isChecked() || (prompt_error_checkbox.isChecked()
                || engine_update_checkbox.isChecked() || data_backup_checkbox.isChecked()
                || check_domens_checkbox.isChecked() || ssl_control_checkbox.isChecked()
                || check_viruses_checkbox.isChecked() || web_server_diagnostic_checkbox.isChecked()
                || hosting_monitoring_checkbox.isChecked() || compatibility_control_checkbox.isChecked()
                || image_size_optimization_checkbox.isChecked()))
                && (!logos_checkbox.isChecked() || (brand_sign_checkbox.isChecked() || brand_name_checkbox.isChecked()
                || slogan_checkbox.isChecked() || brand_character_checkbox.isChecked() || style_elements_checkbox.isChecked()))
        ) {
            Intent intent = new Intent(this, Result.class);
            if (create_site_checkbox.isChecked()) {
                intent.putExtra("create_site", 1);
                intent.putExtra("create_site_cost", 25000);
            }
            else {
                intent.putExtra("create_site", 0);
            }
            if (context_ad_checkbox.isChecked()) {
                intent.putExtra("context_ad", 1);
            }
            else {
                intent.putExtra("context_ad", 0);
            }
            if (yandex_direct_checkbox.isChecked()) {
                intent.putExtra("yandex_direct", 1);
                intent.putExtra("yandex_direct_cost", 6500);
            }
            else {
                intent.putExtra("yandex_direct", 0);
            }
            if (google_ads_checkbox.isChecked()) {
                intent.putExtra("google_ads", 1);
                intent.putExtra("google_ads_cost", 4000);
            }
            else {
                intent.putExtra("google_ads", 0);
            }
            if (smm_and_targeting_checkbox.isChecked()) {
                intent.putExtra("smm_and_targeting", 1);
                intent.putExtra("posts_per_week", posts_per_week_seekbar.getProgress());
                intent.putExtra("post_cost", 99);
            }
            else {
                intent.putExtra("smm_and_targeting", 0);
            }
            if (vkontakte_checkbox.isChecked()) {
                intent.putExtra("vkontakte", 1);
                intent.putExtra("vkontakte_cost", 4000);
            }
            else {
                intent.putExtra("vkontakte", 0);
            }
            if (telegram_checkbox.isChecked()) {
                intent.putExtra("telegram", 1);
                intent.putExtra("telegram_cost", 7500);
            }
            else {
                intent.putExtra("telegram", 0);
            }
            if (year1seo.isChecked()) {
                intent.putExtra("seo", 1);
                intent.putExtra("seo_cost", 123000);
            }
            else if (year2seo.isChecked()) {
                intent.putExtra("seo", 2);
                intent.putExtra("seo_cost", 210000);
            }
            else if (laterseo.isChecked()) {
                intent.putExtra("seo", 3);
            }
            if (technical_support_checkbox.isChecked()) {
                intent.putExtra("technical_support", 1);
            }
            else {
                intent.putExtra("technical_support", 0);
            }
            if (prompt_error_checkbox.isChecked()) {
                intent.putExtra("prompt_error", 1);
                intent.putExtra("prompt_error_cost", 3200);
            }
            else {
                intent.putExtra("prompt_error", 0);
            }
            if (engine_update_checkbox.isChecked()) {
                intent.putExtra("engine_update", 1);
                intent.putExtra("engine_update_cost", 11500);
            }
            else {
                intent.putExtra("engine_update", 0);
            }
            if (data_backup_checkbox.isChecked()) {
                intent.putExtra("data_backup", 1);
                intent.putExtra("data_backup_cost", 18500);
            }
            else {
                intent.putExtra("data_backup", 0);
            }
            if (check_domens_checkbox.isChecked()) {
                intent.putExtra("check_domens", 1);
                intent.putExtra("check_domens_cost", 2500);
            }
            else {
                intent.putExtra("check_domens", 0);
            }
            if (ssl_control_checkbox.isChecked()) {
                intent.putExtra("ssl_control", 1);
                intent.putExtra("ssl_control_cost", 3900);
            }
            else {
                intent.putExtra("ssl_control", 0);
            }
            if (check_viruses_checkbox.isChecked()) {
                intent.putExtra("check_viruses", 1);
                intent.putExtra("check_viruses_cost", 3900);
            }
            else {
                intent.putExtra("check_viruses", 0);
            }
            if (web_server_diagnostic_checkbox.isChecked()) {
                intent.putExtra("web_server_diagnostic", 1);
                intent.putExtra("web_server_diagnostic_cost", 7900);
            }
            else {
                intent.putExtra("web_server_diagnostic", 0);
            }
            if (hosting_monitoring_checkbox.isChecked()) {
                intent.putExtra("hosting_monitoring", 1);
                intent.putExtra("hosting_monitoring_cost", 1900);
            }
            else {
                intent.putExtra("hosting_monitoring", 0);
            }
            if (compatibility_control_checkbox.isChecked()) {
                intent.putExtra("compatibility_control", 1);
                intent.putExtra("compatibility_control_cost", 2500);
            }
            else {
                intent.putExtra("compatibility_control", 0);
            }
            if (image_size_optimization_checkbox.isChecked()) {
                intent.putExtra("image_size_optimization", 1);
                intent.putExtra("image_size_optimization_cost", 900);
            }
            else {
                intent.putExtra("image_size_optimization", 0);
            }
            if (imp_and_refine_crm_checkbox.isChecked()) {
                intent.putExtra("imp_and_refine", 1);
                intent.putExtra("imp_and_refine_crm_cost", 29000);
            }
            else {
                intent.putExtra("imp_and_refine", 0);
            }
            if (logos_checkbox.isChecked()) {
                intent.putExtra("logos", 1);
            }
            else {
                intent.putExtra("logos", 0);
            }
            if (brand_sign_checkbox.isChecked()) {
                intent.putExtra("brand_sign", 1);
                intent.putExtra("brand_sign_cost", 2500);
            }
            else {
                intent.putExtra("brand_sign", 0);
            }
            if (brand_name_checkbox.isChecked()) {
                intent.putExtra("brand_name", 1);
                intent.putExtra("brand_name_cost", 2500);
            }
            else {
                intent.putExtra("brand_name", 0);
            }
            if (slogan_checkbox.isChecked()) {
                intent.putExtra("slogan", 1);
                intent.putExtra("slogan_cost", 500);
            }
            else {
                intent.putExtra("slogan", 0);
            }
            if (brand_character_checkbox.isChecked()) {
                intent.putExtra("brand_character", 1);
                intent.putExtra("brand_character_cost", 2900);
            }
            else {
                intent.putExtra("brand_character", 0);
            }
            if (style_elements_checkbox.isChecked()) {
                intent.putExtra("style_elements", 1);
                intent.putExtra("style_elements_cost", 1400);
            }
            else {
                intent.putExtra("style_elements", 0);
            }
            if (polygraphy_checkbox.isChecked()) {
                intent.putExtra("polygraphy", 1);
                intent.putExtra("polygraphy_cost", 1700);
            }
            else {
                intent.putExtra("polygraphy", 0);
            }

            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Вы не отметили нужные чекбоксы...", Toast.LENGTH_SHORT).show();
        }
    }
}