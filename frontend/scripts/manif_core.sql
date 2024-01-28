-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2024 at 01:36 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manif_core`
--

-- --------------------------------------------------------

--
-- Table structure for table `interest`
--

CREATE TABLE `interest` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `date_created` datetime NOT NULL DEFAULT current_timestamp(),
  `last_update` varchar(23) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `interest`
--

INSERT INTO `interest` (`id`, `name`, `description`, `date_created`, `last_update`) VALUES
(0, 'test2', 'This is a test description.', '2024-01-23 00:33:31', '2024-01-14T15:32:56.000'),
(1, 'Human Rights', 'Advocating for the basic rights and freedoms of all individuals.', '2024-01-10 05:00:00', '2024-01-14T15:32:56.000'),
(2, 'Environmental Justice', 'Supporting efforts to protect the environment and promote sustainability.', '2024-01-11 05:00:00', '2024-01-14T15:32:56.000'),
(3, 'Equality for All', 'Striving for equal rights and opportunities regardless of race, gender, or background.', '2024-01-12 05:00:00', '2024-01-14T15:32:56.000'),
(4, 'Social Justice', 'Promoting fairness and equality in society.', '2024-01-13 05:00:00', '2024-01-14T15:32:56.000'),
(5, 'Climate Change Awareness', 'Raising awareness about the impacts of climate change and advocating for solutions.', '2024-01-14 05:00:00', '2024-01-14T15:32:56.000'),
(6, 'Anti-Corruption', 'Opposing corruption in government and institutions.', '2024-01-15 05:00:00', '2024-01-14T15:32:56.000'),
(7, 'Peace Advocacy', 'Working towards a peaceful and harmonious world.', '2024-01-16 05:00:00', '2024-01-14T15:32:56.000'),
(8, 'Access to Education', 'Ensuring everyone has access to quality education.', '2024-01-17 05:00:00', '2024-01-14T15:32:56.000'),
(9, 'Civic Engagement', 'Encouraging active participation in community and civic affairs.', '2024-01-18 05:00:00', '2024-01-14T15:32:56.000'),
(10, 'Healthcare Reform', 'Advocating for accessible and equitable healthcare for all.', '2024-01-19 05:00:00', '2024-01-14T15:32:56.000'),
(11, 'LGBTQ+ Rights', 'Supporting the rights and inclusion of the LGBTQ+ community.', '2024-01-20 05:00:00', '2024-01-14T15:32:56.000'),
(12, 'Anti-Discrimination', 'Opposing discrimination based on race, religion, or other factors.', '2024-01-21 05:00:00', '2024-01-14T15:32:56.000'),
(13, 'Fair Wage', 'Advocating for fair wages and workers\' rights.', '2024-01-22 05:00:00', '2024-01-14T15:32:56.000'),
(14, 'Refugee Support', 'Providing support and advocating for the rights of refugees.', '2024-01-23 05:00:00', '2024-01-14T15:32:56.000'),
(15, 'Democracy', 'Promoting and protecting democratic values and institutions.', '2024-01-24 05:00:00', '2024-01-14T15:32:56.000'),
(16, 'Droits de l\'Homme', '', '2024-01-24 06:14:38', '2024-01-24T06:15:56.000'),
(17, 'Changement Climatique et Environnement', '', '2024-01-24 06:17:19', '2024-01-24T06:15:56.000');

-- --------------------------------------------------------

--
-- Table structure for table `interest_member`
--

CREATE TABLE `interest_member` (
  `id` int(11) NOT NULL,
  `interest` int(11) NOT NULL,
  `member` varchar(36) NOT NULL,
  `date_created` datetime NOT NULL DEFAULT current_timestamp(),
  `last_update` varchar(23) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `knex_migrations`
--

CREATE TABLE `knex_migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  `migration_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `knex_migrations_lock`
--

CREATE TABLE `knex_migrations_lock` (
  `index` int(10) UNSIGNED NOT NULL,
  `is_locked` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `knex_migrations_lock`
--

INSERT INTO `knex_migrations_lock` (`index`, `is_locked`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `manif`
--

CREATE TABLE `manif` (
  `id` varchar(36) NOT NULL,
  `owner` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `slogan` varchar(36) NOT NULL,
  `city` varchar(255) NOT NULL,
  `meeting` varchar(255) NOT NULL,
  `interest` int(11) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `date_created` datetime NOT NULL DEFAULT current_timestamp(),
  `last_update` varchar(23) NOT NULL DEFAULT 'current_timestamp()'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manif`
--

INSERT INTO `manif` (`id`, `owner`, `name`, `description`, `slogan`, `city`, `meeting`, `interest`, `start_date`, `end_date`, `date_created`, `last_update`) VALUES
('4c1e51a3-178e-442a-9d20-9ee13d9e62d1', '0c8c67fb-6206-4654-b10f-7ed26189ffe5', 'Peaceful Protest 2024', 'A peaceful gathering for a better future.', '9c94ac81-1f84-4dc4-82a2-8d2df1f0c685', 'Cityville', 'Central Park', 5, '2024-02-15 10:00:00', '2024-02-15 16:00:00', '2024-01-10 12:00:00', '2024-01-10T12:00:00.000'),
('8658e41d-106d-4d78-9ce5-2a2b97f7f0a8', '21ab87a9-bccb-46fc-9330-1ae98f3be813', 'Equality March', 'Marching for equality and justice.', '22d10f54-83d5-4a4a-b3c7-5c4bce0c0599', 'Equality Town', 'Main Square', 10, '2024-03-01 14:00:00', '2024-03-01 18:00:00', '2024-01-11 09:30:00', '2024-01-11T09:30:00.000'),
('e3b6c04c-bf04-4f5c-bac5-3a9ddce11239', '30233107-7181-4d93-a646-6b47a023d44a', 'Climate Action Rally', 'Raising awareness for climate change.', '563a23d7-0d8b-4a9c-90f6-8b18133d7b69', 'Green City', 'City Hall', 7, '2024-01-12 11:30:00', '2024-01-12 15:30:00', '2024-01-12 15:45:00', '2024-01-12T15:45:00.000');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` varchar(36) NOT NULL DEFAULT '00000000-0000-0000-0000-000000000000',
  `username` varchar(32) DEFAULT '',
  `password` varchar(255) DEFAULT '',
  `salt` varchar(32) DEFAULT '',
  `description` varchar(255) DEFAULT '',
  `avatar` int(11) DEFAULT 0,
  `mail` varchar(255) NOT NULL,
  `phone` varchar(10) DEFAULT '',
  `last_login` varchar(23) DEFAULT NULL,
  `date_created` varchar(23) DEFAULT 'current_timestamp()',
  `last_update` varchar(23) DEFAULT 'current_timestamp()'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `username`, `password`, `salt`, `description`, `avatar`, `mail`, `phone`, `last_login`, `date_created`, `last_update`) VALUES
('00000000-0000-0000-0000-000000000000', 'admin', '12345678', '', 'Compte administrateur', 0, 'admin@manif.com', '8196993576', '2024-01-10T01:17:06.000', '2024-01-21T04:10:07.000', '2024-01-14T15:32:56.000'),
('00000000-0000-0000-0000-000000000001', 'jntessier', '12345678', '', '', 1, 'jntessier@hotmail.com', '8196993576', '2024-01-10T01:17:06.000', '2024-01-21T04:13:10.000', '2024-01-14T15:32:56.000'),
('0c8c67fb-6206-4654-b10f-7ed26189ffe5', 'Alfonzo45', '12345678', 'mockSalt', 'Expedita eum officia delectus aliquid.', 8, 'Libbie.Nader@yahoo.com', '5575996260', '2024-01-10T01:17:06.000', '2024-01-10T16:29:20.000', '2024-01-14T15:32:56.000'),
('21ab87a9-bccb-46fc-9330-1ae98f3be813', 'Blaze.Hayes50', '12345678', 'mockSalt', 'Rem exercitationem qui sit sed inventore omnis aut maxime.', 4, 'Rhett60@hotmail.com', '4568894611', '2024-01-10T01:17:06.000', '2024-01-10T08:23:13.000', '2024-01-14T15:32:56.000'),
('28eb7316-a37c-4fdf-ad2b-e25aba0d22ad', 'mathieu2', '12345678', '', '', 0, '', '', '2024-01-24T20:56:57.338', '2024-01-24T20:56:57.340', '2024-01-24T20:56:57.344'),
('30233107-7181-4d93-a646-6b47a023d44a', 'Bernhard.Walter99', '12345678', 'mockSalt', 'Laudantium vitae quas tenetur nisi molestias occaecati eos placeat.', 10, 'Mireille50@gmail.com', '4512354565', '2024-01-10T01:17:06.000', '2024-01-10T16:28:29.000', '2024-01-14T15:32:56.000'),
('3c69ffeb-b9d5-4919-b7f0-0d6a17be183e', 'mathieu', '12345678', '', '', 0, '', '', '2024-01-24T20:50:39.604', '2024-01-24T20:50:39.604', '2024-01-24T20:50:39.608'),
('4a5b1083-0ce3-474d-b65f-5e664f9e2cd9', 'Gavin52', '12345678', 'mockSalt', 'Et autem ex cupiditate delectus.', 8, 'Harley12@yahoo.com', '6146064237', '2024-01-10T01:17:06.000', '2024-01-10T07:48:16.000', '2024-01-14T15:32:56.000'),
('602843e1-ceb5-4cb3-a960-95d0af960d81', 'Rahsaan74', '12345678', 'mockSalt', 'Ut fugiat distinctio laudantium.', 2, 'Zechariah.Hirthe4@gmail.com', '5947972923', '2024-01-10T01:17:06.000', '2024-01-10T01:17:06.000', '2024-01-14T15:32:56.000');

-- --------------------------------------------------------

--
-- Table structure for table `member_manif`
--

CREATE TABLE `member_manif` (
  `id` int(11) NOT NULL,
  `manif` varchar(36) NOT NULL,
  `member` varchar(36) NOT NULL,
  `is_present` tinyint(1) NOT NULL,
  `rating` int(11) NOT NULL,
  `date_created` datetime NOT NULL,
  `last_update` varchar(23) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member_manif`
--

INSERT INTO `member_manif` (`id`, `manif`, `member`, `is_present`, `rating`, `date_created`, `last_update`) VALUES
(0, '4c1e51a3-178e-442a-9d20-9ee13d9e62d1', '0c8c67fb-6206-4654-b10f-7ed26189ffe5', 1, 4, '2024-01-11 12:00:00', '2024-01-11T12:00:00.000'),
(1, '8658e41d-106d-4d78-9ce5-2a2b97f7f0a8', '21ab87a9-bccb-46fc-9330-1ae98f3be813', 1, 5, '2024-01-11 14:30:00', '2024-01-11T14:30:00.000'),
(2, 'e3b6c04c-bf04-4f5c-bac5-3a9ddce11239', '30233107-7181-4d93-a646-6b47a023d44a', 0, -1, '2024-01-11 16:45:00', '2024-01-11T16:45:00.000'),
(3, '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000001', 0, 0, '2024-01-11 16:45:00', '2024-01-11T16:45:00.000');

-- --------------------------------------------------------

--
-- Table structure for table `slogan`
--

CREATE TABLE `slogan` (
  `id` varchar(36) NOT NULL,
  `title` varchar(255) NOT NULL,
  `slogan` text NOT NULL,
  `interest` int(11) NOT NULL DEFAULT 0,
  `date_created` datetime NOT NULL DEFAULT current_timestamp(),
  `last_update` varchar(23) NOT NULL DEFAULT 'current_timestamp()'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `slogan`
--

INSERT INTO `slogan` (`id`, `title`, `slogan`, `interest`, `date_created`, `last_update`) VALUES
('22d10f54-83d5-4a4a-b3c7-5c4bce0c0599', 'Green Future, Clean Future', 'Join the movement for a sustainable and environmentally friendly world.', 2, '2022-01-15 11:00:00', '2022-01-15T11:00:00.000'),
('563a23d7-0d8b-4a9c-90f6-8b18133d7b69', 'Unity in Diversity', 'Celebrating differences, fostering unity, and embracing diversity.', 4, '2022-01-15 12:00:00', '2022-01-15T12:00:00.000'),
('7f6d256d-e48f-4a54-bc21-768499235e5b', 'Trans Rights are Human Rights', 'Advocating for the rights and dignity of the transgender community.', 11, '2022-01-15 14:00:00', '2022-01-15T14:00:00.000'),
('9c94ac81-1f84-4dc4-82a2-8d2df1f0c685', 'Stand Up for Equality', 'Together for a world where everyone is treated with fairness and respect.', 3, '2022-01-15 10:00:00', '2022-01-15T10:00:00.000'),
('a134a632-0dab-4b02-8e66-5e5ea63b31b2', 'Justice for Refugees', 'Standing with refugees, ensuring their safety, and protecting their rights.', 14, '2022-01-15 17:00:00', '2022-01-15T17:00:00.000'),
('bb5eddf5-9061-4a9c-b144-0fc82731269d', 'Climate Action Now!', 'Empowering communities to take action against climate change.', 5, '2022-01-15 13:00:00', '2022-01-15T13:00:00.000'),
('d0a7c6cd-9617-4d77-a2cf-83962321b5db', 'Fair Wages, Fair Work', 'Advocating for fair wages and just working conditions for all.', 13, '2022-01-15 18:00:00', '2022-01-15T18:00:00.000'),
('d496ea44-04c1-4a8f-8b72-876ab778bf56', 'Peaceful Hearts, Peaceful World', 'Spreading the message of peace and harmony for a better world.', 7, '2022-01-15 19:00:00', '2022-01-15T19:00:00.000'),
('dc62a62e-75fb-4c04-860b-614662f7d1c0', 'Education for All', 'Supporting accessible and inclusive education for every individual.', 8, '2022-01-15 15:00:00', '2022-01-15T15:00:00.000'),
('faff4db3-21a1-4ee4-8464-89f389265d7b', 'Healthcare is a Right', 'Demanding equitable healthcare access for every person in our society.', 10, '2022-01-15 16:00:00', '2022-01-15T16:00:00.000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `interest`
--
ALTER TABLE `interest`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `interest_member`
--
ALTER TABLE `interest_member`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `member` (`member`);

--
-- Indexes for table `knex_migrations`
--
ALTER TABLE `knex_migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  ADD PRIMARY KEY (`index`);

--
-- Indexes for table `manif`
--
ALTER TABLE `manif`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `owner` (`owner`),
  ADD UNIQUE KEY `slogan` (`slogan`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `member_manif`
--
ALTER TABLE `member_manif`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `manif` (`manif`),
  ADD UNIQUE KEY `member` (`member`);

--
-- Indexes for table `slogan`
--
ALTER TABLE `slogan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `interest_member`
--
ALTER TABLE `interest_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `knex_migrations`
--
ALTER TABLE `knex_migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  MODIFY `index` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `member_manif`
--
ALTER TABLE `member_manif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
