--
-- Licensed to the Apache Software Foundation (ASF) under one
-- or more contributor license agreements.  See the NOTICE file
-- distributed with this work for additional information
-- regarding copyright ownership.  The ASF licenses this file
-- to you under the Apache License, Version 2.0 (the
-- "License"); you may not use this file except in compliance
-- with the License.  You may obtain a copy of the License at
--
--   http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing,
-- software distributed under the License is distributed on an
-- "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
-- KIND, either express or implied.  See the License for the
-- specific language governing permissions and limitations
-- under the License.
--

--
-- Add new system-level audit permission
--

ALTER TYPE guacamole_system_permission_type
    ADD VALUE 'AUDIT'
    BEFORE 'ADMINISTER';

--
-- Add new system-level create watch session permission
--

ALTER TYPE guacamole_system_permission_type
    ADD VALUE 'CREATE_WATCH_SESSION'
    BEFORE 'AUDIT';

--
-- Add watch session table
--

CREATE TABLE guacamole_watch_session (

    watch_session_id serial       NOT NULL,
    username         varchar(128) NOT NULL,
    connection       varchar(128) NOT NULL,
    uuid             varchar(128) NOT NULL,
    restriction      boolean      NOT NULL,
    link             varchar(512) NOT NULL,

    PRIMARY KEY (watch_session_id),

    CONSTRAINT watch_session_user_connection
        UNIQUE (username, connection)
);

--
-- Add watch session permission table
--

CREATE TABLE guacamole_watch_session_permission (

    entity_id        integer NOT NULL,
    watch_session_id integer NOT NULL,
    permission       guacamole_object_permission_type NOT NULL,

    PRIMARY KEY (entity_id, watch_session_id, permission),

    CONSTRAINT guacamole_watch_session_permission_ibfk_1
        FOREIGN KEY (watch_session_id)
        REFERENCES guacamole_watch_session (watch_session_id) ON DELETE CASCADE,

    CONSTRAINT guacamole_watch_session_permission_entity
        FOREIGN KEY (entity_id)
        REFERENCES guacamole_entity (entity_id) ON DELETE CASCADE

);

