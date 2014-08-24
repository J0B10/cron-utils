package com.cron.utils.model.field;

import com.cron.utils.model.field.constraint.FieldConstraints;
import org.apache.commons.lang3.Validate;

/*
 * Copyright 2014 jmrozanec
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public abstract class FieldExpression {

    protected FieldConstraints constraints;

    public FieldExpression(FieldConstraints constraints) {
        Validate.notNull(constraints, "FieldConstraints cannot be null");
        this.constraints = constraints;
    }

    public And and(FieldExpression exp) {
        return new And().and(this).and(exp);
    }

    protected FieldConstraints getConstraints() {
        return constraints;
    }

    public abstract String asString();
}