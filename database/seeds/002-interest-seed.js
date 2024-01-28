// Interest seed file
// database\seeds\interest-seed.js

// Seed
const interests = [
    { id: 0, name: 'test', description: 'This is a test description.', date_created: new Date('2024-01-09T10:00:00.000Z') },
    { id: 1, name: 'Human Rights', description: 'Advocating for the basic rights and freedoms of all individuals.', date_created: new Date('2024-01-10T10:00:00.000Z') },
    { id: 2, name: 'Environmental Justice', description: 'Supporting efforts to protect the environment and promote sustainability.', date_created: new Date('2024-01-11T10:00:00.000Z') },
    { id: 3, name: 'Equality for All', description: 'Striving for equal rights and opportunities regardless of race, gender, or background.', date_created: new Date('2024-01-12T10:00:00.000Z') },
    { id: 4, name: 'Social Justice', description: 'Promoting fairness and equality in society.', date_created: new Date('2024-01-13T10:00:00.000Z') },
    { id: 5, name: 'Climate Change Awareness', description: 'Raising awareness about the impacts of climate change and advocating for solutions.', date_created: new Date('2024-01-14T10:00:00.000Z') },
    { id: 6, name: 'Anti-Corruption', description: 'Opposing corruption in government and institutions.', date_created: new Date('2024-01-15T10:00:00.000Z') },
    { id: 7, name: 'Peace Advocacy', description: 'Working towards a peaceful and harmonious world.', date_created: new Date('2024-01-16T10:00:00.000Z') },
    { id: 8, name: 'Access to Education', description: 'Ensuring everyone has access to quality education.', date_created: new Date('2024-01-17T10:00:00.000Z') },
    { id: 9, name: 'Civic Engagement', description: 'Encouraging active participation in community and civic affairs.', date_created: new Date('2024-01-18T10:00:00.000Z') },
    { id: 10, name: 'Healthcare Reform', description: 'Advocating for accessible and equitable healthcare for all.', date_created: new Date('2024-01-19T10:00:00.000Z') },
    { id: 11, name: 'LGBTQ+ Rights', description: 'Supporting the rights and inclusion of the LGBTQ+ community.', date_created: new Date('2024-01-20T10:00:00.000Z') },
    { id: 12, name: 'Anti-Discrimination', description: 'Opposing discrimination based on race, religion, or other factors.', date_created: new Date('2024-01-21T10:00:00.000Z') },
    { id: 13, name: 'Fair Wage', description: 'Advocating for fair wages and workers\' rights.', date_created: new Date('2024-01-22T10:00:00.000Z') },
    { id: 14, name: 'Refugee Support', description: 'Providing support and advocating for the rights of refugees.', date_created: new Date('2024-01-23T10:00:00.000Z') },
    { id: 15, name: 'Democracy', description: 'Promoting and protecting democratic values and institutions.', date_created: new Date('2024-01-24T10:00:00.000Z') },
  ];
  
exports.seed = function (knex) {
    return knex('interest').del()
        .then(function () {
        return knex('interest').insert(interests);
    });
};
  