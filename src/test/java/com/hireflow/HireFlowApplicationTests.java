package com.hireflow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HireFlowApplicationTests {

    @Test
    void applicationClassIsLoadable() {
        assertThat(HireFlowApplication.class).isNotNull();
    }
}
