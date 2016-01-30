package src.io.teamelite.core.utilities.slack;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class SlackAttachment {
    private String fallback;
    private String text;
    private String pretext;
    private String color;
    private List<SlackField> fields;

    public SlackAttachment addFields(SlackField field) {
        if (this.fields == null) {
            this.fields = new ArrayList<SlackField>();
        }

        this.fields.add(field);

        return this;
    }

    private boolean isHex(String pair) {
        return pair.matches("^([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
    }

	private JSONArray prepareFields() {
        JSONArray data = new JSONArray();
        for (SlackField field : fields) {
            data.add(field.toJson());
        }

        return data;
    }

    public SlackAttachment removeFields(Integer index) {
        if (this.fields != null) {
            this.fields.remove(index);
        }

        return this;
    }

    public SlackAttachment setColor(String color) {
        if (color != null) {
            if (color.charAt(0) == '#') {
                if (!isHex(color.substring(1))) {
                    throw new IllegalArgumentException(
                            "Invalid Hex Color @ SlackAttachment");
                }
            } else
                if (!color.matches("^(good|warning|danger)$")) {
                    throw new IllegalArgumentException(
                            "Invalid PreDefined Color @ SlackAttachment");
                }
        }

        this.color = color;

        return this;
    }

    public SlackAttachment setFallback(String fallback) {
        this.fallback = fallback;

        return this;
    }

    public SlackAttachment setFields(ArrayList<SlackField> fields) {
        this.fields = fields;

        return this;
    }

    public SlackAttachment setPretext(String pretext) {
        this.pretext = pretext;

        return this;
    }

    public SlackAttachment setText(String text) {
        this.text = text;

        return this;
    }

    public JSONObject toJson() {
        JSONObject data = new JSONObject();

        if (fallback == null) {
            throw new IllegalArgumentException(
                    "Missing Fallback @ SlackAttachment");
        } else {
            data.put("fallback", fallback);
        }

        if (text != null) {
            data.put("text", text);
        }

        if (pretext != null) {
            data.put("pretext", pretext);
        }

        if (color != null) {
            data.put("color", color);
        }

        if (fields != null && fields.size() > 0) {
            data.put("fields", prepareFields());
        }

        return data;
    }

}
