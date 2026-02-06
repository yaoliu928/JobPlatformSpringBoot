# Database Schema Files

## Company Link Schema

The `company_link_schema.sql` file creates the table for author-company authorization.

### Usage

Run this SQL in your MySQL database:

```bash
mysql -u root -p job < company_link_schema.sql
```

### Table Structure

- **company_link**: Stores the authorization relationship between authors and companies
  - `link_author`: The author's name who is authorized
  - `link_company`: The company name being linked
  - `link_verified`: Boolean flag indicating if the link is verified/active
