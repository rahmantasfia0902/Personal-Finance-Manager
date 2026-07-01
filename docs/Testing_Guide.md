# PFM Project Testing Guide

**Version:** 1.0  
**Prepared by:** Testing Team

---

## Purpose

This guide outlines the responsibilities and procedures for testing fixes throughout the Personal Finance Manager (PFM) project. Following these guidelines will help ensure that reported issues are properly verified before being marked as complete.

---

## Testing Responsibilities

The Testing Team is responsible for:

- Verifying that reported issues have been resolved.
- Confirming that fixes work as intended.
- Performing basic regression testing to ensure that existing functionality has not been negatively affected.
- Documenting testing results through GitHub issue comments.
- Closing issues that have been successfully resolved.
- Reopening issues if the problem still exists or new issues are discovered.

---

## Testing Process

### Step 1: Receive the Issue

The Test Team Leader will assign the issue to a tester after the developer marks the issue as **Fixed**.

Before testing, review:

- The issue description
- Steps to reproduce the issue
- Any developer comments
- Related commits or pull requests (if available)

---

### Step 2: Verify the Fix

Attempt to reproduce the original issue using the same steps provided in the issue.

Determine whether:

- The original problem has been resolved.
- The application behaves as expected.
- No additional problems were introduced.

---

### Step 3: Perform Regression Testing

After verifying the fix, test any related features that may have been affected.

Examples include:

- Similar pages or screens
- Related calculations
- Connected functionality
- Previously working features

The goal is to ensure the fix did not create new bugs elsewhere in the application.

---

### Step 4: Document Results

Record the testing results by leaving a comment on the GitHub issue.

Include:

- What was tested
- Whether the issue was successfully reproduced
- Whether the fix worked
- Any additional observations

---

### Step 5: Update the Issue Status

If the issue passes testing:

- Change the issue status to **Closed**.

If the issue fails testing:

- Change the issue status back to **Open**.
- Reassign the issue to the original developer.
- Explain why the issue failed and provide any relevant details.

---

## Testing Best Practices

- Follow the issue's reproduction steps carefully.
- Test both expected and unexpected user behavior when appropriate.
- Keep testing notes clear and concise.
- Include screenshots when helpful.
- Report any new issues discovered during testing.
- Never assume a fix works without verifying it.

---

## Tester Checklist

Before closing an issue, confirm that you have completed the following:

- [ ] Reviewed the issue description
- [ ] Reproduced the original issue (if possible)
- [ ] Verified the developer's fix
- [ ] Performed basic regression testing
- [ ] Added testing comments
- [ ] Closed or reopened the issue based on the results

---

## Communication

Communication between developers and testers is essential throughout the testing process.

Use GitHub issue comments to:

- Ask questions
- Request clarification
- Provide testing updates
- Explain why an issue was reopened
- Confirm successful verification

Maintaining clear communication helps ensure that issues are resolved efficiently and accurately.
