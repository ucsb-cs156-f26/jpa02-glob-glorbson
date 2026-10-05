package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_works() {
	Team t1 = new Team();
	t1.setName("foo");
	t1.addMember("bar");

	Team t2 = new Team();
	t2.setName("foo");
	t2.addMember("bar");

	Team t3 = new Team();
	t3.setName("bar");
	t3.addMember("foo");

	Team t4 = new Team();
	t4.setName("foo");
	t4.addMember("foo");

	Team t5 = new Team();
	t5.setName("bar");
	t5.addMember("bar");

	assertEquals(t1.hashCode(), t2.hashCode());
	assertEquals(t1.equals(t1), true);
	assertEquals(t1.equals(t3), false);
	assertEquals(t1.equals(5), false);

	assertEquals(t1.name.equals(t2.name), true);
	assertEquals(t1.members.equals(t2.members), true);
	assertEquals(t1.name.equals(t4.name), true);
	assertEquals(t1.members.equals(t4.members), false);
	assertEquals(t1.name.equals(t3.name), false);
	assertEquals(t1.members.equals(t3.members), false);
	assertEquals(t1.name.equals(t5.name), false);
	assertEquals(t1.members.equals(t5.members), true);
    }

    @Test
    public void hashCode_and_or_equivalent_mutation_check() {
	Team t = new Team();
	int result = t.hashCode();
	int expectedResult = 1;
	assertEquals(expectedResult, result);
    }
}
