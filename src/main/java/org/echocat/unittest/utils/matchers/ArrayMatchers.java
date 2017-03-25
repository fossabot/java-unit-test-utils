package org.echocat.unittest.utils.matchers;

import org.echocat.unittest.utils.utils.StreamUtils;
import org.hamcrest.Matcher;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static org.echocat.unittest.utils.matchers.CombinedMappingMatcher.collectMatchers;

public interface ArrayMatchers {

    @Nonnull
    static <T> Matcher<T[]> containsOnlyElementsThat(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return new ContainsOnlyElementsThat<>(StreamUtils::toStream, matchers);
    }

    @Nonnull
    static <T> Matcher<T[]> containsOnlyElements(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return containsOnlyElementsThat(matchers);
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<T[]> containsOnlyElementsThat(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsOnlyElementsThat(collectMatchers(matcher, otherMatchers));
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<T[]> containsOnlyElements(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsOnlyElementsThat(matcher, otherMatchers);
    }

    @Nonnull
    static <T> Matcher<T[]> containsAtLeastOneElementThat(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return new ContainsAtLeastOneElementThat<>(StreamUtils::toStream, matchers);
    }

    @Nonnull
    static <T> Matcher<T[]> containsAtLeastOneElement(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return containsAtLeastOneElementThat(matchers);
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<T[]> containsAtLeastOneElementThat(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsAtLeastOneElementThat(collectMatchers(matcher, otherMatchers));
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<T[]> containsAtLeastOneElement(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsAtLeastOneElementThat(matcher, otherMatchers);
    }

}