/// <reference types="cypress" />

describe('', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000')

        cy.get('img[alt="Melvin avatar"]').parents('.login__account').click()

        cy.visit('http://localhost:3000/transfer')
    })


    it('geld overboeken naar een ander account', () => {

        cy.get('select[name="toaccount"]').select('Sara Ravestein')

        cy.get('.amount-input').type(100)

        cy.get('textarea[name="description"]').type('Dit is een bericht voor het overboeken')

        cy.get('button[type="submit"]').click()
    })
})