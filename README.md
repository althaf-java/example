Didn't cover any unit tests for invalid data like start = 0, page size greater than results size, results = null and etc.
Refactoring required in HandlePaginationImpl.getPagination (for loop)