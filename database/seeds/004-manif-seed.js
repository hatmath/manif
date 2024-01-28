// Manif seed file
// database\seeds\manif-seed.js

/* uuid used:
4c1e51a3-178e-442a-9d20-9ee13d9e62d1
8658e41d-106d-4d78-9ce5-2a2b97f7f0a8
e3b6c04c-bf04-4f5c-bac5-3a9ddce11239
*/

// Seed
const mockManifs = [
    {
      id: '4c1e51a3-178e-442a-9d20-9ee13d9e62d1',
      owner: '0c8c67fb-6206-4654-b10f-7ed26189ffe5',
      name: 'Peaceful Protest 2024',
      description: 'A peaceful gathering for a better future.',
      slogan: '9c94ac81-1f84-4dc4-82a2-8d2df1f0c685',
      city: 'Cityville',
      meeting: 'Central Park',
      interest: 5,
      start_date: '2024-02-15 10:00:00',
      end_date: '2024-02-15 16:00:00',
      date_created: '2024-01-10 12:00:00',
      last_update: '2024-01-10 12:00:00',
    },
    {
      id: '8658e41d-106d-4d78-9ce5-2a2b97f7f0a8',
      owner: '21ab87a9-bccb-46fc-9330-1ae98f3be813',
      name: 'Equality March',
      description: 'Marching for equality and justice.',
      slogan: '22d10f54-83d5-4a4a-b3c7-5c4bce0c0599',
      city: 'Equality Town',
      meeting: 'Main Square',
      interest: 10,
      start_date: '2024-03-01 14:00:00',
      end_date: '2024-03-01 18:00:00',
      date_created: '2024-01-11 09:30:00',
      last_update: '2024-01-11 09:30:00',
    },
    {
      id: 'e3b6c04c-bf04-4f5c-bac5-3a9ddce11239',
      owner: '30233107-7181-4d93-a646-6b47a023d44a',
      name: 'Climate Action Rally',
      description: 'Raising awareness for climate change.',
      slogan: '563a23d7-0d8b-4a9c-90f6-8b18133d7b69',
      city: 'Green City',
      meeting: 'City Hall',
      interest: 7,
      start_date: '2024-01-12 11:30:00',
      end_date: '2024-01-12 15:30:00',
      date_created: '2024-01-12 15:45:00',
      last_update: '2024-01-12 15:45:00',
    },
  ];
  
  exports.seed = function (knex) {
    return knex('manif').del()
      .then(function () {
        return knex('manif').insert(mockManifs);
      });
  };
  