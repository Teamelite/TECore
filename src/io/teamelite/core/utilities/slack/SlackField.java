package io.teamelite.core.utilities.slack;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class SlackField {
    private List<String> allowMarkdown = null;
    private boolean shorten = false;
    private String title = null;
    private String value = null;

    public void addAllowedMarkdown(String field) {
        if (this.allowMarkdown == null) {
            this.allowMarkdown = new ArrayList<String>();
        }

        if (field.matches("^(pretext|text|title|fields|fallback)$")) {
            this.allowMarkdown.add(field);
        } else {
            throw new IllegalArgumentException(
                    field
                            + " is not allowed. Allowed: pretext, text, title, fields and fallback");
        }
    }

    public boolean isShorten() {
        return shorten;
    }

    private JSONArray prepareMarkdown() {
        JSONArray data = new JSONArray();
        for (String item : this.allowMarkdown) {
            data.add(item);
        }

        return data;
    }

    public void setAllowedMarkdown(ArrayList<String> allowMarkdown) {
        if (allowMarkdown != null) {
            this.allowMarkdown = allowMarkdown;
        }
    }

    public void setShorten(boolean shorten) {
        this.shorten = shorten;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public JSONObject toJson() {
        JSONObject data = new JSONObject();
        data.put("title", title);
        data.put("value", value);
        data.put("short", shorten);
        if (allowMarkdown != null && allowMarkdown.size() > 0) {
            data.put("mrkdwn_in", prepareMarkdown());
        }

        return data;
    }

}
