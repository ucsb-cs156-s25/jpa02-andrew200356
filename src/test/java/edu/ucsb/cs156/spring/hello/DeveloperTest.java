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
        Team team = new Team("s25-02");
        team.addMember("Shiyuan wang");
        team.addMember("Ayala Wang");
        team.addMember("Mujia Chen");
        team.addMember("Xinyan Zhao");
        team.addMember("Evania Cheng");
        team.addMember("Jiahua Ren");
        assertEquals(team.toString(), Developer.getTeam().toString());
    }
}
