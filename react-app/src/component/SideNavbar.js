import React, { Component } from "react";
import { Nav, Button } from "react-bootstrap";
import { logout } from "../actions/SecurityActions";
import { connect } from "react-redux";
import { NavLink } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faPowerOff,
  faCalendarCheck,
  faBus,
  faBullhorn,
  faHandPaper,
  faUsers,
  faUsersCog,
  faRoute,
  faMapMarkerAlt
} from "@fortawesome/free-solid-svg-icons";

class SideNavbar extends Component {
  constructor(props) {
    super(props);
    this.processLogout = this.processLogout.bind(this);
  }

  processLogout = () => {
    if (window.confirm("Do you want to logout?")) {
      this.props.logout();
      this.props.navigate("/"); // ✅ React Router navigation
    }
  };

  render() {
    return (
      <Nav
        variant="pills"
        className="flex-column"
        style={{
          padding: "10px",
          border: "1px solid gray",
          borderRadius: "5px",
          fontSize: "14px",
          fontWeight: "500"
        }}
      >
        <Nav.Link as={NavLink} to="/schedule">
          <FontAwesomeIcon icon={faCalendarCheck} />
          {" Schedule"}
        </Nav.Link>

        <Nav.Link as={NavLink} to="/bus">
          <FontAwesomeIcon icon={faBus} />
          {" Bus"}
        </Nav.Link>

        <Nav.Link as={NavLink} to="/stoppage">
          <FontAwesomeIcon icon={faMapMarkerAlt} />
          {" Stoppage"}
        </Nav.Link>

        <Nav.Link as={NavLink} to="/route">
          <FontAwesomeIcon icon={faRoute} />
          {" Route"}
        </Nav.Link>

        <Nav.Link as={NavLink} to="/driver">
          <FontAwesomeIcon icon={faUsersCog} />
          {" Driver"}
        </Nav.Link>

        <Nav.Link as={NavLink} to="/stuff">
          <FontAwesomeIcon icon={faUsers} />
          {" Stuff"}
        </Nav.Link>

        <Nav.Link as={NavLink} to="/notice">
          <FontAwesomeIcon icon={faBullhorn} />
          {" Notice"}
        </Nav.Link>

        <Nav.Link as={NavLink} to="/feedback">
          <FontAwesomeIcon icon={faHandPaper} />
          {" Feedback"}
        </Nav.Link>

        <br />

        <Button
          size="sm"
          variant="outline-danger"
          onClick={this.processLogout}
        >
          <FontAwesomeIcon icon={faPowerOff} />
          {" Logout"}
        </Button>
      </Nav>
    );
  }
}

export default connect(null, { logout })(SideNavbar);