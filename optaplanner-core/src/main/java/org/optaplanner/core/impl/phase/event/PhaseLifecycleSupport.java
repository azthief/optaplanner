/*
 * Copyright 2011 JBoss Inc
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

package org.optaplanner.core.impl.phase.event;

import java.util.Iterator;

import org.optaplanner.core.impl.phase.scope.AbstractPhaseScope;
import org.optaplanner.core.impl.phase.scope.AbstractStepScope;
import org.optaplanner.core.impl.solver.event.AbstractEventSupport;
import org.optaplanner.core.impl.solver.scope.DefaultSolverScope;

/**
 * Internal API.
 */
public class PhaseLifecycleSupport extends AbstractEventSupport<PhaseLifecycleListener> {

    public void fireSolvingStarted(DefaultSolverScope solverScope) {
        for (PhaseLifecycleListener phaseLifecycleListener : eventListenerSet) {
            phaseLifecycleListener.solvingStarted(solverScope);
        }
    }

    public void firePhaseStarted(AbstractPhaseScope phaseScope) {
        for (PhaseLifecycleListener phaseLifecycleListener : eventListenerSet) {
            phaseLifecycleListener.phaseStarted(phaseScope);
        }
    }

    public void fireStepStarted(AbstractStepScope stepScope) {
        for (PhaseLifecycleListener phaseLifecycleListener : eventListenerSet) {
            phaseLifecycleListener.stepStarted(stepScope);
        }
    }

    public void fireStepEnded(AbstractStepScope stepScope) {
        for (PhaseLifecycleListener phaseLifecycleListener : eventListenerSet) {
            phaseLifecycleListener.stepEnded(stepScope);
        }
    }

    public void firePhaseEnded(AbstractPhaseScope phaseScope) {
        for (PhaseLifecycleListener phaseLifecycleListener : eventListenerSet) {
            phaseLifecycleListener.phaseEnded(phaseScope);
        }
    }

    public void fireSolvingEnded(DefaultSolverScope solverScope) {
        for (PhaseLifecycleListener phaseLifecycleListener : eventListenerSet) {
            phaseLifecycleListener.solvingEnded(solverScope);
        }
    }

}
