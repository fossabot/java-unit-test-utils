package org.echocat.unittest.utils.matchers;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Spliterator;

import static java.util.Arrays.asList;
import static org.echocat.unittest.utils.matchers.CompareTo.isGreaterThanOrEqualTo;
import static org.echocat.unittest.utils.matchers.CompareTo.isLessThanOrEqualTo;
import static org.echocat.unittest.utils.matchers.SpliteratorMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class SpliteratorMatchersUnitTest {

    protected static final Matcher<Integer> MATCHER1 = isGreaterThanOrEqualTo(0);
    protected static final Matcher<Integer> MATCHER2 = isLessThanOrEqualTo(10);

    @Test
    public void factoryMethodContainsOnlyElementsThat() throws Exception {
        final Matcher<Spliterator<Integer>> instance = containsOnlyElementsThat(MATCHER1, MATCHER2);

        assertThat(instance, instanceOf(ContainsOnlyElementsThat.class));
        assertThat(((CombinedMappingMatcher<?, ?>) instance).matchers(), equalTo(asList(MATCHER1, MATCHER2)));
    }

    @Test
    public void factoryMethodContainsOnlyElements() throws Exception {
        final Matcher<Spliterator<Integer>> instance = containsOnlyElements(MATCHER1, MATCHER2);

        assertThat(instance, instanceOf(ContainsOnlyElementsThat.class));
        assertThat(((CombinedMappingMatcher<?, ?>) instance).matchers(), equalTo(asList(MATCHER1, MATCHER2)));
    }

    @Test
    public void factoryMethodContainsAtLeastOneElementThat() throws Exception {
        final Matcher<Spliterator<Integer>> instance = containsAtLeastOneElementThat(MATCHER1, MATCHER2);

        assertThat(instance, instanceOf(ContainsAtLeastOneElementThat.class));
        assertThat(((CombinedMappingMatcher<?, ?>) instance).matchers(), equalTo(asList(MATCHER1, MATCHER2)));
    }

    @Test
    public void factoryMethodContainsAtLeastOneElement() throws Exception {
        final Matcher<Spliterator<Integer>> instance = containsAtLeastOneElement(MATCHER1, MATCHER2);

        assertThat(instance, instanceOf(ContainsAtLeastOneElementThat.class));
        assertThat(((CombinedMappingMatcher<?, ?>) instance).matchers(), equalTo(asList(MATCHER1, MATCHER2)));
    }

    @Test
    public void constructor() {
        new SpliteratorMatchers();
    }

}
