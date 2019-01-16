package com.udacity.gradle.builditbigger;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.annotation.Config;

@Config(manifest = Config.NONE)
@RunWith(MockitoJUnitRunner.class)
public class EndpointsAsyncTaskTest {

    private EndpointsAsyncTask task;

    @Before
    public void setUp() {
        task = Mockito.mock(EndpointsAsyncTask.class);
    }

    @Test
    public void execute_True_ifTheResultIsThisIsTotallyFunnyJoke() {
        final String correctResult = "You see a hand-crafted brilliant joke";


        task.setContract(new CallbackAsyncTask() {
            @Override
            public void getResult(String result) {
                Truth.assertThat(result.equals(correctResult)).isTrue();
            }

        });

        task.execute();
    }
}
