# Container Order Rule

![Freelancer](doc/preview.gif
)

## Usage

This module provides a simple example of a Custom Order Rule Type for Liferay Commerce.  In this scenario, we are 
going to assume that customers will get special pricing if they elect to receive a shipping container of merchandise.  

At this time, Order Rules are not enabled by default and must be enabled through Systems Settings.  After enabling Order
Rules, and deploying the module you can create a new Order Rule through the Global Menu > Commerce > Order Rules.   When 
creating a new Order Rule  you must provide a name and select the Order Rule Type of Container Order Rule and then 
Submit.  The Container Order Rule requires three configurations, the maximum container volume, maximum container weight, 
and a packing efficiency modifier (The packing efficiency modifier is used to provide a realistic estimate because it is 
not possible to use all available space.  A modifier of .7 or .8 would be typical.)  On the _Eligibility_ tab you can
optionally target this rule to specific Accounts, Account Groups, Channels, or Order Types.  

## Requirements

- Liferay Commerce 4.0.0
- As of Update 18, Order Rules must be enabled through Control Panel > System Settings > Orders > Order Rules

## Installation

- Download the `.jar` file in [releases](https://github.com/jhanda/container-order-rule/releases/tag/4.0.0-u18) and deploy it 
into Liferay.

or

- Clone this repository, add it to a Liferay workspace and deploy it into Liferay.

## License

[MIT](LICENSE)
