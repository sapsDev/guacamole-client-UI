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

EXEC sp_unbindrule 'guacamole_system_permission';
DROP RULE [guacamole_system_permission_list];
GO

CREATE RULE [guacamole_system_permission_list] AS @list IN (
    'CREATE_CONNECTION',
    'CREATE_CONNECTION_GROUP',
    'CREATE_SHARING_PROFILE',
    'CREATE_USER',
    'CREATE_USER_GROUP',
    'CREATE_WATCH_SESSION',
    'AUDIT',
    'ADMINISTER'
);
GO

EXEC sp_bindrule
    'guacamole_system_permission_list',
    'guacamole_system_permission';
GO

--
--Add watch session table
--

CREATE TABLE [guacamole_watch_session] (
    [watch_session_id] [int] IDENTITY(1,1) NOT NULL,
    [username]         [nvarchar](128)     NOT NULL,
    [connection]       [nvarchar](128)     NOT NULL,
    [uuid]             [nvarchar](128)     NOT NULL,
    [restriction]      [bit]               NOT NULL,
    [link]             [nvarchar](512)     NOT NULL,

    CONSTRAINT [PK_guacamole_watch_session]
        PRIMARY KEY CLUSTERED ([watch_session_id]),

    CONSTRAINT [AK_guacamole_watch_session_user_connection]
        UNIQUE ([username], [connection])
);

--
--Add watch session permission table
--

CREATE TABLE [guacamole_watch_session_permission] (

    [entity_id]        [int]                         NOT NULL,
    [watch_session_id] [int]                         NOT NULL,
    [permission]       [guacamole_object_permission] NOT NULL,

    CONSTRAINT [PK_guacamole_watch_session_permission]
        PRIMARY KEY CLUSTERED ([entity_id], [watch_session_id], [permission]),

    CONSTRAINT [FK_guacamole_watch_session_permission_watch_session_id]
        FOREIGN KEY ([watch_session_id])
        REFERENCES [guacamole_watch_session] ([watch_session_id])
        ON DELETE CASCADE,

    CONSTRAINT [FK_guacamole_watch_session_permission_entity_id]
        FOREIGN KEY ([entity_id])
        REFERENCES [guacamole_entity] ([entity_id])
        ON DELETE CASCADE

);