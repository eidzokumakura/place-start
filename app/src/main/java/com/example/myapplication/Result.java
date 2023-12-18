package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;


public class Result extends AppCompatActivity {

    int result_cost = 0;
    TextView total_result;
    int context_ad_total = 0;
    int smm_and_targeting_total = 0;
    int technical_support_total = 0;
    int logos_total = 0;
    View create_site_result;
    TextView create_site_cost;
    View context_ad_result;
    TextView context_ad_cost;
    View smm_and_targeting_result;
    TextView smm_and_targeting_cost;
    View seo_promotion_result;
    TextView seo_promotion_cost;
    View technical_support_result;
    TextView technical_support_cost;
    View imp_and_refine_crm_result;
    TextView imp_and_refine_crm_cost;
    View logos_result;
    TextView logos_cost;
    View polygraphy_result;
    TextView polygraphy_cost;

    TextView yandex_direct_result;
    TextView google_ads_result;

    // Чекбоксы смм и таргетинга
    TextView vkontakte_result;
    TextView telegram_result;
    TextView posts_per_week_result;

    // Радио сео-продвижения
    TextView seo_result;

    // Чекбоксы технического сопровождения
    TextView prompt_error_result;
    TextView engine_update_result;
    TextView data_backup_result;
    TextView check_domens_result;
    TextView ssl_control_result;
    TextView check_viruses_result;
    TextView web_server_diagnostic_result;
    TextView hosting_monitoring_result;
    TextView compatibility_control_result;
    TextView image_size_optimization_result;

    // Чекбоксы логотипа и фирменного стиля
    TextView brand_sign_result;
    TextView brand_name_result;
    TextView slogan_result;
    TextView brand_character_result;
    TextView style_elements_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle arguments = getIntent().getExtras();

        total_result = findViewById(R.id.total_result);

        create_site_result = findViewById(R.id.create_site_result);
        context_ad_result = findViewById(R.id.context_ad_result);
        smm_and_targeting_result = findViewById(R.id.smm_and_targeting_result);
        seo_promotion_result = findViewById(R.id.seo_promotion_result);
        technical_support_result = findViewById(R.id.technical_support_result);
        imp_and_refine_crm_result = findViewById(R.id.imp_and_refine_crm_result);
        logos_result = findViewById(R.id.logos_result);
        polygraphy_result = findViewById(R.id.polygraphy_result);

        create_site_cost = findViewById(R.id.create_site_cost);
        context_ad_cost = findViewById(R.id.context_ad_cost);
        smm_and_targeting_cost = findViewById(R.id.smm_and_targeting_cost);
        seo_promotion_cost = findViewById(R.id.seo_promotion_cost);
        technical_support_cost = findViewById(R.id.technical_support_cost);
        imp_and_refine_crm_cost = findViewById(R.id.imp_and_refine_crm_cost);
        logos_cost = findViewById(R.id.logos_cost);
        polygraphy_cost = findViewById(R.id.polygraphy_cost);

        yandex_direct_result = findViewById(R.id.yandex_direct_result);
        google_ads_result = findViewById(R.id.google_ads_result);
        vkontakte_result = findViewById(R.id.vkontakte_result);
        telegram_result = findViewById(R.id.telegram_result);
        posts_per_week_result = findViewById(R.id.posts_per_week_result);
        seo_result = findViewById(R.id.seo_promotion_time);
        prompt_error_result = findViewById(R.id.prompt_error_result);
        engine_update_result = findViewById(R.id.engine_update_result);
        data_backup_result = findViewById(R.id.data_backup_result);
        check_domens_result = findViewById(R.id.check_domens_result);
        ssl_control_result = findViewById(R.id.ssl_control_result);
        check_viruses_result = findViewById(R.id.check_viruses_result);
        web_server_diagnostic_result = findViewById(R.id.web_server_diagnostic_result);
        hosting_monitoring_result = findViewById(R.id.hosting_monitoring_result);
        compatibility_control_result = findViewById(R.id.compatibility_control_result);
        image_size_optimization_result = findViewById(R.id.image_size_optimization_result);
        brand_sign_result = findViewById(R.id.brand_sign_result);
        brand_name_result = findViewById(R.id.brand_name_result);
        slogan_result = findViewById(R.id.slogan_result);
        brand_character_result = findViewById(R.id.brand_character_result);
        style_elements_result = findViewById(R.id.style_elements_result);

        // Создание сайта
        if (arguments.getInt("create_site") == 1) {
            create_site_result.setVisibility(View.VISIBLE);
            create_site_cost.setText("" + arguments.getInt("create_site_cost") + " руб.");
            result_cost += arguments.getInt("create_site_cost");
        }
        else {
            create_site_result.setVisibility(View.GONE);
        }

        // Контекстная реклама
        if (arguments.getInt("context_ad") == 1) {
            context_ad_result.setVisibility(View.VISIBLE);
        }
        else {
            context_ad_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("yandex_direct") == 1) {
            yandex_direct_result.setVisibility(View.VISIBLE);
            context_ad_total += arguments.getInt("yandex_direct_cost");
        }
        else {
            yandex_direct_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("google_ads") == 1) {
            google_ads_result.setVisibility(View.VISIBLE);
            context_ad_total += arguments.getInt("google_ads_cost");
        }
        else {
            google_ads_result.setVisibility(View.GONE);
        }
        context_ad_cost.setText("" + context_ad_total + " руб.");
        result_cost += context_ad_total;

        if (arguments.getInt("smm_and_targeting") == 1) {
            smm_and_targeting_result.setVisibility(View.VISIBLE);
            posts_per_week_result.setText("•	Постов в неделю: " + arguments.getInt("posts_per_week"));
            smm_and_targeting_total += arguments.getInt("post_cost") * arguments.getInt("posts_per_week");
        }
        else {
            smm_and_targeting_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("vkontakte") == 1) {
            vkontakte_result.setVisibility(View.VISIBLE);
            smm_and_targeting_total += arguments.getInt("vkontakte_cost");
        }
        else {
            vkontakte_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("telegram") == 1) {
            telegram_result.setVisibility(View.VISIBLE);
            smm_and_targeting_total += arguments.getInt("telegram_cost");
        }
        else {
            telegram_result.setVisibility(View.GONE);
        }
        smm_and_targeting_cost.setText("" + smm_and_targeting_total + " руб.");
        result_cost += smm_and_targeting_total;

        // Сео - продвижение
        if (arguments.getInt("seo") == 1) {
            seo_promotion_result.setVisibility(View.VISIBLE);
            seo_result.setText("•\tСрок: 1 год");
            seo_promotion_cost.setText("" + arguments.getInt("seo_cost") + " руб.");
            result_cost += arguments.getInt("seo_cost");
        }
        else if (arguments.getInt("seo") == 2) {
            seo_promotion_result.setVisibility(View.VISIBLE);
            seo_result.setText("•\tСрок: 2 года");
            seo_promotion_cost.setText("" + arguments.getInt("seo_cost") + " руб.");
            result_cost += arguments.getInt("seo_cost");
        }
        else if (arguments.getInt("seo") == 3) {
            seo_promotion_result.setVisibility(View.VISIBLE);
            seo_result.setText("•\tСрок: обговаривается\nотдельно");
            seo_promotion_cost.setVisibility(View.GONE);
        }
        else {
            seo_promotion_result.setVisibility(View.GONE);
        }

        // Техническая поддержка
        if (arguments.getInt("technical_support") == 1) {
            technical_support_result.setVisibility(View.VISIBLE);
        }
        else {
            technical_support_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("prompt_error") == 1) {
            prompt_error_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("prompt_error_cost");
        }
        else {
            prompt_error_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("engine_update") == 1) {
            engine_update_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("engine_update_cost");
        }
        else {
            engine_update_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("data_backup") == 1) {
            data_backup_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("data_backup_cost");
        }
        else {
            data_backup_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("check_domens") == 1) {
            check_domens_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("check_domens_cost");
        }
        else {
            check_domens_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("ssl_control") == 1) {
            ssl_control_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("ssl_control_cost");
        }
        else {
            ssl_control_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("check_viruses") == 1) {
            check_viruses_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("check_viruses_cost");
        }
        else {
            check_viruses_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("web_server_diagnostic") == 1) {
            web_server_diagnostic_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("web_server_diagnostic_cost");
        }
        else {
            web_server_diagnostic_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("hosting_monitoring") == 1) {
            hosting_monitoring_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("hosting_monitoring_cost");
        }
        else {
            hosting_monitoring_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("compatibility_control") == 1) {
            compatibility_control_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("compatibility_control_cost");
        }
        else {
            compatibility_control_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("image_size_optimization") == 1) {
            image_size_optimization_result.setVisibility(View.VISIBLE);
            technical_support_total += arguments.getInt("image_size_optimization_cost");
        }
        else {
            image_size_optimization_result.setVisibility(View.GONE);
        }
        technical_support_cost.setText("" + technical_support_total + " руб.");
        result_cost += technical_support_total;

        // Внедрение и доработка CRM
        if (arguments.getInt("imp_and_refine") == 1) {
            imp_and_refine_crm_result.setVisibility(View.VISIBLE);
            imp_and_refine_crm_cost.setText("" + arguments.getInt("imp_and_refine_crm_cost") + " руб.");
            result_cost += arguments.getInt("imp_and_refine_crm_cost");
        }
        else {
            imp_and_refine_crm_result.setVisibility(View.GONE);
        }

        // Логотипы и фирменный стиль
        if (arguments.getInt("logos") == 1) {
            logos_result.setVisibility(View.VISIBLE);
        }
        else {
            logos_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("brand_sign") == 1) {
            brand_sign_result.setVisibility(View.VISIBLE);
            logos_total += arguments.getInt("brand_sign_cost");
        }
        else {
            brand_sign_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("brand_name") == 1) {
            brand_name_result.setVisibility(View.VISIBLE);
            logos_total += arguments.getInt("brand_name_cost");
        }
        else {
            brand_name_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("slogan") == 1) {
            slogan_result.setVisibility(View.VISIBLE);
            logos_total += arguments.getInt("slogan_cost");
        }
        else {
            slogan_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("brand_character") == 1) {
            brand_character_result.setVisibility(View.VISIBLE);
            logos_total += arguments.getInt("brand_character_cost");
        }
        else {
            brand_character_result.setVisibility(View.GONE);
        }
        if (arguments.getInt("style_elements") == 1) {
            style_elements_result.setVisibility(View.VISIBLE);
            logos_total += arguments.getInt("style_elements_cost");
        }
        else {
            style_elements_result.setVisibility(View.GONE);
        }
        logos_cost.setText("" + logos_total + " руб.");
        result_cost += logos_total;

        // Полиграфия
        if (arguments.getInt("polygraphy") == 1) {
            polygraphy_result.setVisibility(View.VISIBLE);
            polygraphy_cost.setText("" + arguments.getInt("polygraphy_cost") + " руб.");
            result_cost += arguments.getInt("polygraphy_cost");
        }
        else {
            polygraphy_result.setVisibility(View.GONE);
        }
        total_result.setText("Конечный итог:\n" + result_cost + " руб.");
        try {
            // Создание JSON-объекта
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("technical_support", technical_support_total);
            jsonObject.put("context_ad", context_ad_total);

            // Создание JSON-массива и добавление в него JSON-объекта
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);

            // Запись JSON-массива в файл
            FileWriter file = new FileWriter("file.json");
            file.write(jsonArray.toString());
            file.flush();
            file.close();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Back(View view) {
        Intent intent = new Intent(this, RateSettings.class);
        startActivity(intent);
    }
    public void Call(View view) {
        String number = "tel:89215498673";
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
    }
    public void Map(View view) {
        String url = "https://yandex.ru/maps/-/CDqObB4C";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}