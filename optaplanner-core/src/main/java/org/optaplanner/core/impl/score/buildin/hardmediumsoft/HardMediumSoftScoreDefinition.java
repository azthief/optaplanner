/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.core.impl.score.buildin.hardmediumsoft;

import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScoreHolder;
import org.optaplanner.core.config.score.trend.InitializingScoreTrendLevel;
import org.optaplanner.core.impl.score.definition.AbstractFeasibilityScoreDefinition;
import org.optaplanner.core.impl.score.trend.InitializingScoreTrend;

public class HardMediumSoftScoreDefinition extends AbstractFeasibilityScoreDefinition<HardMediumSoftScore> {

    // ************************************************************************
    // Worker methods
    // ************************************************************************

    @Override
    public int getLevelsSize() {
        return 3;
    }

    @Override
    public int getFeasibleLevelsSize() {
        return 1;
    }

    public Class<HardMediumSoftScore> getScoreClass() {
        return HardMediumSoftScore.class;
    }

    public HardMediumSoftScore parseScore(String scoreString) {
        return HardMediumSoftScore.parseScore(scoreString);
    }

    public HardMediumSoftScoreHolder buildScoreHolder(boolean constraintMatchEnabled) {
        return new HardMediumSoftScoreHolder(constraintMatchEnabled);
    }

    public HardMediumSoftScore buildOptimisticBound(InitializingScoreTrend initializingScoreTrend, HardMediumSoftScore score) {
        InitializingScoreTrendLevel[] trendLevels = initializingScoreTrend.getTrendLevels();
        return HardMediumSoftScore.valueOf(
                trendLevels[0] == InitializingScoreTrendLevel.ONLY_DOWN ? score.getHardScore() : Integer.MAX_VALUE,
                trendLevels[1] == InitializingScoreTrendLevel.ONLY_DOWN ? score.getMediumScore() : Integer.MAX_VALUE,
                trendLevels[2] == InitializingScoreTrendLevel.ONLY_DOWN ? score.getSoftScore() : Integer.MAX_VALUE);
    }

    public HardMediumSoftScore buildPessimisticBound(InitializingScoreTrend initializingScoreTrend, HardMediumSoftScore score) {
        InitializingScoreTrendLevel[] trendLevels = initializingScoreTrend.getTrendLevels();
        return HardMediumSoftScore.valueOf(
                trendLevels[0] == InitializingScoreTrendLevel.ONLY_UP ? score.getHardScore() : Integer.MIN_VALUE,
                trendLevels[1] == InitializingScoreTrendLevel.ONLY_UP ? score.getMediumScore() : Integer.MIN_VALUE,
                trendLevels[2] == InitializingScoreTrendLevel.ONLY_UP ? score.getSoftScore() : Integer.MIN_VALUE);
    }

}
