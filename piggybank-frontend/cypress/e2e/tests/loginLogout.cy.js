/// <reference types="cypress" />

describe('', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000')

        cy.get('img[alt="Melvin avatar"]').parents('.login__account').click()
    })

    it('logout', () => {
        cy.get('.app__logout button').click()
    })
})