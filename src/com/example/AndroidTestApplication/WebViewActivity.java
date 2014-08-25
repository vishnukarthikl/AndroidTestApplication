package com.example.AndroidTestApplication;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        String html = "<html>\n" +
                "<head>\n" +
                "    <script>\n" +
                "        function press() {\n" +
                "            document.getElementById(\"result\").innerText = \"button was pressed\"\n" +
                "        }\n" +
                "    </script>\n" +
                "    <title>Webview Android</title>\n" +
                "    <input type=\"text\" class=\"input_text\" id=\"first_input\"/> <br/>\n" +
                "    <input type=\"date\" class=\"input_date\" id=\"second_input\"/> <br/>\n" +
                "    <input type=\"email\" class=\"input_email\" id=\"third_input\"/> <br/>\n" +
                "    <button id=\"first_button\" class=\"press_me_button\" onclick=press()>Press Me\n" +
                "    </button>\n" +
                "    <br>\n" +
                "\n" +
                "    <div id=\"result\">\n" +
                "\n" +
                "    </div>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        webView.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
    }
}
