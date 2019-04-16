CREATE TABLE `search_code` (
  `id` bigint(20) unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `content` text NOT NULL,
  `downloads_url` varchar(200) NOT NULL DEFAULT '',
  `downloads_url_content` text,
  `hashcode` int(11) NOT NULL,
  `q` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_hashcode` (`hashcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;