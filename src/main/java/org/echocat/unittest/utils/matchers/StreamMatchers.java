package org.echocat.unittest.utils.matchers;

import org.echocat.unittest.utils.utils.StreamUtils;
import org.hamcrest.Matcher;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

import static org.echocat.unittest.utils.matchers.CombinedMappingMatcher.collectMatchers;

public interface StreamMatchers {

    @Nonnull
    static <T> Matcher<Stream<T>> containsOnlyElementsThat(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return new ContainsOnlyElementsThat<>(StreamUtils::toStream, matchers);
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<Stream<T>> containsOnlyElementsThat(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsOnlyElementsThat(collectMatchers(matcher, otherMatchers));
    }

    @Nonnull
    static <T> Matcher<Stream<T>> containsOnlyElements(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return containsOnlyElementsThat(matchers);
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<Stream<T>> containsOnlyElements(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsOnlyElements(collectMatchers(matcher, otherMatchers));
    }

    @Nonnull
    static <T> Matcher<Stream<T>> containsAtLeastOneElementThat(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return new ContainsAtLeastOneElementThat<>(StreamUtils::toStream, matchers);
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<Stream<T>> containsAtLeastOneElementThat(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsAtLeastOneElementThat(collectMatchers(matcher, otherMatchers));
    }

    @Nonnull
    static <T> Matcher<Stream<T>> containsAtLeastOneElement(@Nonnull Iterable<? extends Matcher<T>> matchers) {
        return containsAtLeastOneElementThat(matchers);
    }

    @SafeVarargs
    @Nonnull
    static <T> Matcher<Stream<T>> containsAtLeastOneElement(@Nonnull Matcher<T> matcher, @Nullable Matcher<T>... otherMatchers) {
        return containsAtLeastOneElement(collectMatchers(matcher, otherMatchers));
    }

}
