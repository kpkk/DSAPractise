
Code review checklist:
- know about the changes (read PR title / desc)
    - if needed have a short call with author to know at a high level
- If needed look at the associated jira ticket, to get context
    - if any wiki pages (go over them)
- How big is a PR? 100+ files can’t be reviewed
    - may be ask author break them down to several stacked PRs
- Check all the checks on the PR are passing
    - code smells (sonar is red)
    - some UTs broke
    - ask them to show the green results for the review
- Files reviews
    - look for imports (unused, *, not at all recommended)
    - look for any dead code
    - any hardcoded inputs (move them to constants / class level constants)
    - Look for logic, identify any race conditions / flakiness / incorrectness
    - look for redundant DS assignments / initialisations / focus on simplicity and readability 
    - look for test coverages for the new code
    - Cognitive complexity - method is too big to understand, so many inputs
        - break into smaller modules
    - Changes added to the right files or not (SRP)
    - any reusable utility can be moved to utils / common functions
    - if we have any function defined already, ask author re-use instead adding a new one
    - API req / response structures, make them into POJO classes instead of maps/ string objects
    - variable / method names /class naming conventions
    - Folder / package structure 
    - git ignore (to ignore unncessary files)
    - any secrets being exposed or hardcoded
    - Look for OOps / design principles / coding best practises
    - if optimisation needed, can see if design patterns can be applicable
 

import java.utils.ArrayList<>
ArrayList<>();
