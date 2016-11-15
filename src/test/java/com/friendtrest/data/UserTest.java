package com.friendtrest.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

public class UserTest {

    private String email;
    private String facebookID;
    private String name;
    private String pictureURL;

    private List<String> friendIDs;
    private List<String> reviewIDs;

    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        email = "ericbaby@baby.com";
        facebookID = "1234567";
        name = "Eric Baby";
        pictureURL = "codys_branch.jpg";
        friendIDs = Arrays.asList("1234", "5678");
        reviewIDs = Arrays.asList("8765", "4321");

        user1 = new User();
        user2 = new User(name, email, pictureURL, facebookID, friendIDs);
        user3 = new User(name, email, pictureURL, facebookID, reviewIDs, friendIDs);
    }

    @Test
    public void testNoArg() {
        assertTrue(allNull(user1));
    }

    @Test
    public void testConstructorMinusReviews() {
        String email = user2.getEmail();
        String facebookID = user2.getFacebookId();
        String name = user2.getName();
        String pictureURL = user2.getPictureURL();
        List<String> friends = user2.getFriends();

        assertTrue(checkEqual(name, email, pictureURL, facebookID, friends));
    }

    @Test
    public void testConstructorFull() {
        String email = user3.getEmail();
        String facebookID = user3.getFacebookId();
        String name = user3.getName();
        String pictureURL = user3.getPictureURL();
        List<String> friends = user3.getFriends();
        List<String> reviews = user3.getReviews();

        assertTrue(checkEqual(name, email, pictureURL, facebookID, friends, reviews));
    }

    @Test
    public void testGetEmail() {
        assertThat(user3.getEmail(), equalTo(email));
    }

    @Test
    public void testGetFacebookID() {
        assertThat(user3.getFacebookId(), equalTo(facebookID));
    }

    @Test
    public void testGetName() {
        assertThat(user3.getName(), equalTo(name));
    }

    @Test
    public void testGetPictureURL() {
        assertThat(user3.getPictureURL(), equalTo(pictureURL));
    }

    @Test
    public void testGetFriends() {
        assertThat(user3.getFriends(), equalTo(friendIDs));
    }

    @Test
    public void testGetReviews() {
        assertThat(user3.getReviews(), equalTo(reviewIDs));
    }

    @Test
    public void testSetEmail() {
        String email = "new-email@email.com";

        user3.setEmail(email);

        assertThat(user3.getEmail(), equalTo(email));
    }

    @Test
    public void testSetFacebookID() {
        String facebookID = "99999999";

        user3.setFacebookId(facebookID);

        assertThat(user3.getFacebookId(), equalTo(facebookID));
    }

    @Test
    public void testSetName() {
        String name = "Baby Eric";

        user3.setName(name);

        assertThat(user3.getName(), equalTo(name));
    }

    @Test
    public void testSetPictureURL() {
        String pictureURL = "THIS IS A PICTURE URL";

        user3.setPictureURL(pictureURL);

        assertThat(user3.getPictureURL(), equalTo(pictureURL));
    }

    @Test
    public void testSetFriends() {
        List<String> list = Arrays.asList("list_item1", "list_item2");

        user3.setFriends(list);

        assertThat(user3.getFriends(), equalTo(list));
    }

    @Test
    public void testSetReviews() {
        List<String> list = Arrays.asList("list_item1", "list_item2");

        user3.setReviews(list);

        assertThat(user3.getReviews(), equalTo(list));
    }

    public boolean allNull(List<String> ids) {
        for (String s : ids) {
            if (s != null)
                return false;
        }
        return true;
    }

    public boolean allNull(User user) {
        try {
            return user.getEmail() == null &&
                    user.getFacebookId() == null &&
                    user.getName() == null &&
                    user.getPictureURL() == null &&
                    allNull(user.getFriends()) &&
                    allNull(user.getReviews());
        } catch (NullPointerException e) {
            return true;
        }
    }

    public boolean checkEqual(List<String> ids, List<String> test_ids) {
        for (int i = 0; i < ids.size(); i++) {
            if (!ids.get(i).equals(test_ids.get(i)))
                return false;
        }
        return true;
    }

    public boolean checkEqual(String name, String email, String pictureURL, String facebookID, List<String> friendIDs) {
        return this.name == name &&
                this.email == email &&
                this.pictureURL == pictureURL &&
                this.facebookID == facebookID &&
                checkEqual(friendIDs, this.friendIDs);
    }

    public boolean checkEqual(String name, String email, String pictureURL, String facebookID, List<String> friendIDs, List<String> reviewIDs) {
        return this.name == name &&
                this.email == email &&
                this.pictureURL == pictureURL &&
                this.facebookID == facebookID &&
                checkEqual(friendIDs, this.friendIDs) &&
                checkEqual(reviewIDs, this.reviewIDs);
    }
}
