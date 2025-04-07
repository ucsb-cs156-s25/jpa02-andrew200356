package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from
        // https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()), "Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Shiyuan Wang", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGithubId_returns_correct_github_id() {
        assertEquals("andrew200356", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        // since the team name is hardcoded, we can just check if the team is the same
        Team t = Developer.getTeam();
        assertEquals("s25-02", t.getName());
        assertTrue(t.getMembers().contains("Shiyuan Wang"));
        assertTrue(t.getMembers().contains("Ayala Wang"));
        assertTrue(t.getMembers().contains("Mujia Chen"));
        assertTrue(t.getMembers().contains("Xinyan Zhao"));
        assertTrue(t.getMembers().contains("Evania Cheng"));
        assertTrue(t.getMembers().contains("Jiahua Ren"));
    }

    @Test
    public void getTeam_returns_team_with_Shiyuan() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Shiyuan Wang"), "Team should contain Shiyuan");
    }

    @Test
    public void getTeam_returns_team_with_Ayala() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ayala"), "Team should contain Ayala");
    }

    @Test
    public void getTeam_returns_team_with_Mujia() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Mujia"), "Team should contain Mujia");
    }

    @Test
    public void getTeam_returns_team_with_Xinyan() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Xinyan"), "Team should contain Xinyan");
    }

    @Test
    public void getTeam_returns_team_with_Evania() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Evania"), "Team should contain Evania");
    }

    @Test
    public void getTeam_returns_team_with_Jiahua() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Jiahua"), "Team should contain Jiahua");
    }
}
