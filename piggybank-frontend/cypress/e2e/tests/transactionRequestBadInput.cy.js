/// <reference types="cypress" />

describe('', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000')

        cy.get('img[alt="Melvin avatar"]').parents('.login__account').click()

        cy.visit('http://localhost:3000/transfer')
    })


    it('geld overboeken naar een ander account bad input', () => {

        cy.get('select[name="toaccount"]').select('Sara Ravestein')

        // bad input -negative number
        cy.get('.amount-input').type(-100)

        // bad input not a number
        cy.get('.amount-input').type("dit is geen num")

        cy.get('textarea[name="description"]').type('Dit is een bericht')

        cy.get('button[type="submit"]').click()
    })
})