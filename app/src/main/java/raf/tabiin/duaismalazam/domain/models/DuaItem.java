package raf.tabiin.duaismalazam.domain.models;

public class DuaItem {
    public String duaArabicText;
    public String duaTranscriptText;
    public String duaTranslateText;
    public String separatorEmptyStringLine = "";

    public DuaItem(String duaArabicText, String duaTranscriptText, String duaTranslateText, String separatorEmptyStringLine) {
        this.duaArabicText = duaArabicText;
        this.duaTranscriptText = duaTranscriptText;
        this.duaTranslateText = duaTranslateText;
        this.separatorEmptyStringLine = "";
    }

    public String getDuaArabicText() {
        return duaArabicText;
    }

    public void setDuaArabicText(String duaArabicText) {
        this.duaArabicText = duaArabicText;
    }

    public String getDuaTranscriptText() {
        return duaTranscriptText;
    }

    public void setDuaTranscriptText(String duaTranscriptText) {
        this.duaTranscriptText = duaTranscriptText;
    }

    public String getDuaTranslateText() {
        return duaTranslateText;
    }

    public void setDuaTranslateText(String duaTranslateText) {
        this.duaTranslateText = duaTranslateText;
    }

    public String getSeparatorEmptyStringLine() {
        return separatorEmptyStringLine;
    }

    public void setSeparatorEmptyStringLine(String separatorEmptyStringLine) {
        this.separatorEmptyStringLine = separatorEmptyStringLine;
    }
}
