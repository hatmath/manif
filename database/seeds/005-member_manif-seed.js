// Member by manif seed file
// database\seeds\member_manif-seed.js

// Seed
const mockMemberManifs = [
    {
      manif: '4c1e51a3-178e-442a-9d20-9ee13d9e62d1',
      member: '0c8c67fb-6206-4654-b10f-7ed26189ffe5',
      is_present: true,
      rating: 4,
      date_created: '2024-01-11 12:00:00',
      last_update: '2024-01-11 12:00:00',
    },
    {
      manif: '8658e41d-106d-4d78-9ce5-2a2b97f7f0a8',
      member: '21ab87a9-bccb-46fc-9330-1ae98f3be813',
      is_present: true,
      rating: 5,
      date_created: '2024-01-11 14:30:00',
      last_update: '2024-01-11 14:30:00',
    },
    {
      manif: 'e3b6c04c-bf04-4f5c-bac5-3a9ddce11239',
      member: '30233107-7181-4d93-a646-6b47a023d44a',
      is_present: false,
      rating: -1,
      date_created: '2024-01-11 16:45:00',
      last_update: '2024-01-11 16:45:00',
    },
    // Add more entries as needed
  ];
  
  exports.seed = function (knex) {
    return knex('member_manif').del()
      .then(function () {
        return knex('member_manif').insert(mockMemberManifs);
      });
  };
  