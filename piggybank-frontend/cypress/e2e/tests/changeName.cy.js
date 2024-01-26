/// <reference types="cypress" />

describe('', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000')

        cy.get('img[alt="Melvin avatar"]').parents('.login__account').click()

        cy.visit('http://localhost:3000/settings')
    })

    it('change account name', () => {
        cy.get('.accountName-input').type("newName");

        cy.get('button[type="submit"]').click()
    })
})