// Member seed file
// database\seeds\member-seed.js

/* uuid list :
0c8c67fb-6206-4654-b10f-7ed26189ffe5
21ab87a9-bccb-46fc-9330-1ae98f3be813
30233107-7181-4d93-a646-6b47a023d44a
4a5b1083-0ce3-474d-b65f-5e664f9e2cd9
602843e1-ceb5-4cb3-a960-95d0af960d81
*/

// Seed
const mockMembers = [
  {
    id: '0c8c67fb-6206-4654-b10f-7ed26189ffe5',
    username: 'Alfonzo45',
    password: 'hashedPassword',
    salt: 'mockSalt',
    description: 'Expedita eum officia delectus aliquid.',
    avatar: 8,
    mail: 'Libbie.Nader@yahoo.com',
    phone: '5575996260',
    last_login: '2023-04-28 18:28:25',
    date_created: '2024-01-10 16:29:20',
    last_update: '2024-01-09 23:04:04',
  },
  {
    id: '21ab87a9-bccb-46fc-9330-1ae98f3be813',
    username: 'Blaze.Hayes50',
    password: 'hashedPassword',
    salt: 'mockSalt',
    description: 'Rem exercitationem qui sit sed inventore omnis aut maxime.',
    avatar: 4,
    mail: 'Rhett60@hotmail.com',
    phone: '4568894611',
    last_login: '2023-11-21 08:22:39',
    date_created: '2024-01-10 08:23:13',
    last_update: '2024-01-10 00:02:03',
  },
  {
    id: '30233107-7181-4d93-a646-6b47a023d44a',
    username: 'Bernhard.Walter99',
    password: 'hashedPassword',
    salt: 'mockSalt',
    description: 'Laudantium vitae quas tenetur nisi molestias occaecati eos placeat.',
    avatar: 10,
    mail: 'Mireille50@gmail.com',
    phone: '4512354565',
    last_login: '2023-08-06 00:38:55',
    date_created: '2024-01-10 16:28:29',
    last_update: '2024-01-10 13:25:25',
  },
  {
    id: '4a5b1083-0ce3-474d-b65f-5e664f9e2cd9',
    username: 'Gavin52',
    password: 'hashedPassword',
    salt: 'mockSalt',
    description: 'Et autem ex cupiditate delectus.',
    avatar: 8,
    mail: 'Harley12@yahoo.com',
    phone: '6146064237',
    last_login: '2023-07-08 10:11:33',
    date_created: '2024-01-10 07:48:16',
    last_update: '2024-01-10 03:09:29',
  },
  {
    id: '602843e1-ceb5-4cb3-a960-95d0af960d81',
    username: 'Rahsaan74',
    password: 'hashedPassword',
    salt: 'mockSalt',
    description: 'Ut fugiat distinctio laudantium.',
    avatar: 2,
    mail: 'Zechariah.Hirthe4@gmail.com',
    phone: '5947972923',
    last_login: '2023-08-23 20:54:52',
    date_created: '2024-01-10 01:17:06',
    last_update: '2024-01-09 22:49:45',
  }
];

exports.seed = function (knex) {
  return knex('member').del()
    .then(function () {
      return knex('member').insert(mockMembers);
    });
};
