package com.friendtrest.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Zac Leids on 10/4/2016.
 */
@DynamoDBTable(tableName = "Items")
public class Item {

    private String uuid;
    private String name;
    private String description;
    private List<String> tags;
    private String releaseDate;
    private String url;

    public Item() { }

    public Item(String url) {
        this.uuid = UUID.randomUUID().toString();
        this.url = url;
    }

    @DynamoDBHashKey(attributeName = "uuid")
    public String getUUID() { return uuid; }
    public void setUUID(String uuid) { this.uuid = uuid; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @DynamoDBAttribute(attributeName = "url")
    public String getURL() { return url; }
    public void setURL(String url) { this.url = url; }

    @DynamoDBIgnore
    public void addTag(String tag){
        tags.add(tag);
    }
    @DynamoDBIgnore
    public void removeTag(String tag){
        tags.remove(tag);
    }
    @DynamoDBIgnore
    public int getNumTags(){
        return tags.size();
    }
}
