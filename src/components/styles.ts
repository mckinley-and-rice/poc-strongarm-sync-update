import { StyleSheet, Dimensions } from 'react-native';

export default StyleSheet.create({
	customButton: {
		backgroundColor: "#333",
		marginLeft: 100,
		marginRight: 100,
		marginTop: 30,
		width: Dimensions.get('window').width - 70,
		paddingTop: 20,
		paddingBottom: 20,
		textAlign: 'center',
		alignSelf: 'center',
		shadowOffset: { width: 10, height: 10 },
		shadowColor: "#000",
		shadowOpacity: 1.0,
		borderColor: "#000",
		borderStyle: 'solid',
		borderWidth: 1,
		elevation: 1,
		borderRadius: 5,
	},
	customButtonText: {
		textAlign: 'center',
		width: '100%',
		alignSelf: 'center',
		color: "#fff",
  },
  listItemView: {
    backgroundColor: '#555',
    padding: 10,
    borderBottomColor: '#000',
    borderBottomWidth: 2,
    marginLeft: 30,
    marginRight: 30,
    paddingLeft: 50
  },
  listItemText: {
    fontSize: 20,
    color: '#fff'
  }
});
