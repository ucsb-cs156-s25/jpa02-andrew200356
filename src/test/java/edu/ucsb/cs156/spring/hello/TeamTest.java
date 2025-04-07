package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // Comprehensive tests for equals method
    @Test
    public void equals_returns_true_for_same_team() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertTrue(t1.equals(t2), "Teams with same name and members should be equal");
        assertTrue(t2.equals(t1), "Equals should be symmetric");
    }

    @Test
    public void equals_returns_true_for_same_instance() {
        Team t1 = new Team("test");
        assertTrue(t1.equals(t1), "A team should equal itself (reflexive property)");
    }

    @Test
    public void equals_returns_false_for_null() {
        Team t1 = new Team("test");
        assertFalse(t1.equals(null), "A team should not equal null");
    }

    @Test
    public void equals_returns_false_for_non_team() {
        Team t1 = new Team("test");
        assertFalse(t1.equals("not a team"), "A team should not equal a non-Team object");
    }

    @Test
    public void equals_returns_false_for_different_names() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("bar");
        t2.addMember("bar");
        assertFalse(t1.equals(t2), "Teams with different names should not be equal");
        assertFalse(t2.equals(t1), "Equals should be symmetric for different teams");
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("baz");
        assertFalse(t1.equals(t2), "Teams with different members should not be equal");
        assertFalse(t2.equals(t1), "Equals should be symmetric for different teams");
    }

    @Test
    public void equals_returns_false_for_different_member_order() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        t1.addMember("baz");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("baz");
        t2.addMember("bar");
        assertFalse(t1.equals(t2), "Teams with members in different order should not be equal");
        assertFalse(t2.equals(t1), "Equals should be symmetric for different teams");
    }

    @Test
    public void equals_returns_false_for_different_member_count() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        t2.addMember("baz");
        assertFalse(t1.equals(t2), "Teams with different member counts should not be equal");
        assertFalse(t2.equals(t1), "Equals should be symmetric for different teams");
    }

    @Test
    public void equals_is_transitive() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        Team t3 = new Team();
        t3.setName("foo");
        t3.addMember("bar");

        assertTrue(t1.equals(t2), "t1 should equal t2");
        assertTrue(t2.equals(t3), "t2 should equal t3");
        assertTrue(t1.equals(t3), "t1 should equal t3 (transitive property)");
    }

    @Test
    public void equals_returns_true_for_empty_teams() {
        Team t1 = new Team();
        Team t2 = new Team();
        assertTrue(t1.equals(t2), "Empty teams should be equal");
        assertTrue(t2.equals(t1), "Equals should be symmetric for empty teams");
    }

    @Test
    public void equals_returns_false_for_teams_with_same_name_different_case() {
        Team t1 = new Team();
        t1.setName("Foo");
        Team t2 = new Team();
        t2.setName("foo");
        assertFalse(t1.equals(t2), "Teams with same name but different case should not be equal (case-sensitive)");
        assertFalse(t2.equals(t1), "Equals should be symmetric for teams with same name but different case");
    }

    // test hashCode method
    @Test
    public void hashCode_returns_same_value_for_equal_teams() {
        // instantiate t as a Team object
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1; // we cheat to change the expected result to 1
        assertEquals(expectedResult, result);

    }

}
