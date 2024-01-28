// Slogan seed file
// database\seeds\slogan-seed.js

/* uuid used:
9c94ac81-1f84-4dc4-82a2-8d2df1f0c685
22d10f54-83d5-4a4a-b3c7-5c4bce0c0599
563a23d7-0d8b-4a9c-90f6-8b18133d7b69
bb5eddf5-9061-4a9c-b144-0fc82731269d
7f6d256d-e48f-4a54-bc21-768499235e5b
dc62a62e-75fb-4c04-860b-614662f7d1c0
faff4db3-21a1-4ee4-8464-89f389265d7b
a134a632-0dab-4b02-8e66-5e5ea63b31b2
d0a7c6cd-9617-4d77-a2cf-83962321b5db
d496ea44-04c1-4a8f-8b72-876ab778bf56
*/

// Seed
const slogans = [
    {
      id: '9c94ac81-1f84-4dc4-82a2-8d2df1f0c685',
      title: 'Stand Up for Equality',
      slogan: 'Together for a world where everyone is treated with fairness and respect.',
      interest: 3,
      date_created: '2022-01-15 10:00:00',
      last_update: '2022-01-15 10:00:00'
    },
    {
      id: '22d10f54-83d5-4a4a-b3c7-5c4bce0c0599',
      title: 'Green Future, Clean Future',
      slogan: 'Join the movement for a sustainable and environmentally friendly world.',
      interest: 2,
      date_created: '2022-01-15 11:00:00',
      last_update: '2022-01-15 11:00:00'
    },
    {
      id: '563a23d7-0d8b-4a9c-90f6-8b18133d7b69',
      title: 'Unity in Diversity',
      slogan: 'Celebrating differences, fostering unity, and embracing diversity.',
      interest: 4,
      date_created: '2022-01-15 12:00:00',
      last_update: '2022-01-15 12:00:00'
    },
    {
      id: 'bb5eddf5-9061-4a9c-b144-0fc82731269d',
      title: 'Climate Action Now!',
      slogan: 'Empowering communities to take action against climate change.',
      interest: 5,
      date_created: '2022-01-15 13:00:00',
      last_update: '2022-01-15 13:00:00'
    },
    {
      id: '7f6d256d-e48f-4a54-bc21-768499235e5b',
      title: 'Trans Rights are Human Rights',
      slogan: 'Advocating for the rights and dignity of the transgender community.',
      interest: 11,
      date_created: '2022-01-15 14:00:00',
      last_update: '2022-01-15 14:00:00'
    },
    {
      id: 'dc62a62e-75fb-4c04-860b-614662f7d1c0',
      title: 'Education for All',
      slogan: 'Supporting accessible and inclusive education for every individual.',
      interest: 8,
      date_created: '2022-01-15 15:00:00',
      last_update: '2022-01-15 15:00:00'
    },
    {
      id: 'faff4db3-21a1-4ee4-8464-89f389265d7b',
      title: 'Healthcare is a Right',
      slogan: 'Demanding equitable healthcare access for every person in our society.',
      interest: 10,
      date_created: '2022-01-15 16:00:00',
      last_update: '2022-01-15 16:00:00'
    },
    {
      id: 'a134a632-0dab-4b02-8e66-5e5ea63b31b2',
      title: 'Justice for Refugees',
      slogan: 'Standing with refugees, ensuring their safety, and protecting their rights.',
      interest: 14,
      date_created: '2022-01-15 17:00:00',
      last_update: '2022-01-15 17:00:00'
    },
    {
      id: 'd0a7c6cd-9617-4d77-a2cf-83962321b5db',
      title: 'Fair Wages, Fair Work',
      slogan: 'Advocating for fair wages and just working conditions for all.',
      interest: 13,
      date_created: '2022-01-15 18:00:00',
      last_update: '2022-01-15 18:00:00'
    },
    {
      id: 'd496ea44-04c1-4a8f-8b72-876ab778bf56',
      title: 'Peaceful Hearts, Peaceful World',
      slogan: 'Spreading the message of peace and harmony for a better world.',
      interest: 7,
      date_created: '2022-01-15 19:00:00',
      last_update: '2022-01-15 19:00:00'
    },
  ];
  
  exports.seed = function (knex) {
    return knex('slogan').del()
      .then(function () {
        return knex('slogan').insert(slogans);
      });
  };
  