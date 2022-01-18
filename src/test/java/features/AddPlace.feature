Feature: Validating API

  @addPlace
  Scenario Outline: AddPlace API
    Given json payload with "<name>" "<number>" "<add>"
    When user hits the "addPlaceAPI" with "post" http request
    Then "status" is "OK"
    And "scope" is "APP"
    And verify the "<name>" in the response matches with given name using "getPlaceAPI"

    Examples:
    |name |number       |add      |
    |max  |63278324     | andhra  |
    #| kane|3216478699   | spdarea |

  @deletePlace
    Scenario: Validating DeletePlaceAPI
      Given deletePlace Json payload
      When user hits the "deletePlaceAPI" with "post" http request
      Then "status" is "OK"