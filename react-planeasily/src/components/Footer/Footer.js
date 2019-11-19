/*eslint-disable*/
import React from "react";
import PropTypes from "prop-types";
// @material-ui/core components
import { makeStyles } from "@material-ui/core/styles";
import ListItem from "@material-ui/core/ListItem";
import List from "@material-ui/core/List";
// core components
import styles from "assets/jss/material-dashboard-react/components/footerStyle.js";
import Primary from "components/Typography/Primary.js";


const useStyles = makeStyles(styles);

export default function Footer(props) {
  const classes = useStyles();
  return (
    <footer className={classes.footer}>
      <div className={classes.container}>
        <Primary>
          <h6 color="primary">Team: Adam Johns,  Diane Nguyen,  Nick Soultanian, Theresa Van, Annie Wu</h6>
        </Primary>
        {/* <div className={classes.right}>
          <Primary>
          <List className={classes.list}>
            <ListItem className={classes.inlineBlock}>
              <h2>Adam Johns</h2>
            </ListItem>
            <ListItem className={classes.inlineBlock}>
              <h6 color="primary"> Diane Nguyen</h6>
            </ListItem>
            <ListItem className={classes.inlineBlock}>
              <p>Nick Soultanian</p>
            </ListItem>
            <ListItem className={classes.inlineBlock}>
              <p>Theresa Van</p>
            </ListItem>
            <ListItem className={classes.inlineBlock}>
              <p>Annie Wu</p>
            </ListItem>
          </List>
          </Primary>
        </div> */}

      </div>
    </footer>
  );
}
