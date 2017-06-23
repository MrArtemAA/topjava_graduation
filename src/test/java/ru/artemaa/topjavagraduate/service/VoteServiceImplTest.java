package ru.artemaa.topjavagraduate.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.artemaa.topjavagraduate.model.Vote;
import ru.artemaa.topjavagraduate.util.exception.LateVoteException;

import java.time.LocalDate;
import java.time.LocalTime;

import static ru.artemaa.topjavagraduate.RestaurantTestData.REST1;
import static ru.artemaa.topjavagraduate.RestaurantTestData.REST1_ID;
import static ru.artemaa.topjavagraduate.UserTestData.USER_ID;
import static ru.artemaa.topjavagraduate.service.VoteServiceImpl.VOTE_DEADLINE;

/**
 * @author Artem Areshko
 *         22.06.2017
 */
public class VoteServiceImplTest extends AbstractServiceTest {

    @Autowired
    private VoteService service;

    @Test
    public void testVote() throws Exception {
        service.vote(USER_ID, REST1_ID);
    }

    @Test
    public void testVoteChange() throws Exception {
        if (LocalTime.now().isAfter(VOTE_DEADLINE)) {
            thrown.expect(LateVoteException.class);
        }
        service.vote(USER_ID, REST1_ID);
        service.vote(USER_ID, REST1_ID);
    }

    @Test
    @Transactional
    public void testGetByUser() throws Exception {
        service.vote(USER_ID, REST1_ID);
        Vote vote = service.getByUser(USER_ID, LocalDate.now());
        Assert.assertEquals(LocalDate.now(), vote.getDate());
        Assert.assertEquals(REST1.getId(), vote.getRestaurant().getId());
    }

}