// Interest_member seed file
// database\seeds\interest_member-seed.js

// Seed
const mockInterestMembers = [
    {
      interest: 3,
      member: '0c8c67fb-6206-4654-b10f-7ed26189ffe5',
      date_created: '2024-01-03 10:00:00',
    },
    {
      interest: 8,
      member: '21ab87a9-bccb-46fc-9330-1ae98f3be813',
      date_created: '2024-01-04 12:30:00',
    },
    {
      interest: 5,
      member: '30233107-7181-4d93-a646-6b47a023d44a',
      date_created: '2024-01-05 15:45:00',
    },
    {
      interest: 10,
      member: '4a5b1083-0ce3-474d-b65f-5e664f9e2cd9',
      date_created: '2024-01-06 09:15:00',
    },
    {
      interest: 2,
      member: '602843e1-ceb5-4cb3-a960-95d0af960d81',
      date_created: '2024-01-07 14:00:00',
    },
    {
      interest: 12,
      member: '0c8c67fb-6206-4654-b10f-7ed26189ffe5',
      date_created: '2024-01-08 11:30:00',
    },
    {
      interest: 7,
      member: '21ab87a9-bccb-46fc-9330-1ae98f3be813',
      date_created: '2024-01-09 13:45:00',
    },
    {
      interest: 4,
      member: '30233107-7181-4d93-a646-6b47a023d44a',
      date_created: '2024-01-10 16:00:00',
    },
    {
      interest: 15,
      member: '4a5b1083-0ce3-474d-b65f-5e664f9e2cd9',
      date_created: '2024-01-11 08:30:00',
    },
    {
      interest: 9,
      member: '602843e1-ceb5-4cb3-a960-95d0af960d81',
      date_created: '2024-01-12 12:15:00',
    },
    {
      interest: 6,
      member: '0c8c67fb-6206-4654-b10f-7ed26189ffe5',
      date_created: '2024-01-13 14:45:00',
    },
    {
      interest: 11,
      member: '21ab87a9-bccb-46fc-9330-1ae98f3be813',
      date_created: '2024-01-14 09:00:00',
    }
  ];
  
  exports.seed = function (knex) {
    return knex('interest_member').del()
      .then(function () {
        return knex('interest_member').insert(mockInterestMembers);
      });
  };
  