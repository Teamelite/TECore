package io.teamelite.core.utilities.slack;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class SlackMessage {
	private List<SlackAttachment> attach = null;
    private String channel = null;
    private String icon = null;
    private JSONObject slackMessage = new JSONObject();

    private String text = null;
    private String username = null;

    private boolean unfurlMedia = false;
    private boolean unfurlLinks = false;

    public SlackMessage() {
    }

    public SlackMessage(String text) {
        this(null, null, text);
    }

    public SlackMessage(String username, String text) {
        this(null, username, text);
    }

    public SlackMessage(String channel, String username, String text) {
        if (channel != null) {
            this.channel = channel;
        }

        if (username != null) {
            this.username = username;
        }

        this.text = text;
    }

    public SlackMessage addAttachments(SlackAttachment attach) {
        if (this.attach == null) {
            this.attach = new ArrayList<SlackAttachment>();
        }
        this.attach.add(attach);

        return this;
    }

    /**
     * Convert SlackMessage to JSON
     * 
     * @return JSONObject
     */
    public JSONObject prepare() {
        if (channel != null) {
            slackMessage.put("channel", channel);
        }

        if (username != null) {
            slackMessage.put("username", username);
        }

        if (icon != null) {
            if (icon.contains("http")) {
                slackMessage.put("icon_url", icon);
            } else {
                slackMessage.put("icon_emoji", icon);
            }
        }

        slackMessage.put("unfurl_media", unfurlMedia);
        slackMessage.put("unfurl_links", unfurlLinks);

        if (text == null) {
            throw new IllegalArgumentException("Missing Text field @ SlackMessage");
        } else {
            slackMessage.put("text", text);
        }

        if (attach != null && attach.size() > 0) {
            slackMessage.put("attachments", this.prepareAttach());
        }

        return slackMessage;
    }

    private JSONArray prepareAttach() {
        JSONArray attachs = new JSONArray();
        for (SlackAttachment attach : this.attach) {
            attachs.add(attach.toJson());
        }

        return attachs;
    }

    public SlackMessage removeAttachment(Integer index) {
        if (this.attach != null) {
            this.attach.remove(index);
        }
        return this;
    }

    public SlackMessage setAttachments(ArrayList<SlackAttachment> attach) {
        this.attach = attach;
        return this;
    }

    public SlackMessage setChannel(String channel) {
        if (channel != null) {
            this.channel = channel;
        }
        return this;
    }

    /**
     * See more icons in http://www.emoji-cheat-sheet.com/
     * 
     * @param icon
     *            Avatar
     * @return SlackMessage
     */
    public SlackMessage setIcon(String icon) {
        if (icon != null) {
            this.icon = icon;
        }
        return this;
    }

    public SlackMessage setText(String message) {
        if (message != null) {
            this.text = message;
        }
        return this;
    }

    public SlackMessage setUsername(String username) {
        if (username != null) {
            this.username = username;
        }
        return this;
    }

    public SlackMessage setUnfurlMedia(boolean unfurlMedia) {
        this.unfurlMedia = unfurlMedia;
        return this;
    }

    public SlackMessage setUnfurlLinks(boolean unfurlLinks) {
        this.unfurlLinks = unfurlLinks;
        return this;
    }

}
